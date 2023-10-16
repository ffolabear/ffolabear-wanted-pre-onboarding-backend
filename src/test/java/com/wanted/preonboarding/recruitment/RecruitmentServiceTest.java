package com.wanted.preonboarding.recruitment;

import com.wanted.preonboarding.common.Tech;
import com.wanted.preonboarding.config.TestConfig;
import com.wanted.preonboarding.recruitment.dto.RecruitmentRegisterDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentUpdateDto;
import com.wanted.preonboarding.recruitment.entity.Company;
import com.wanted.preonboarding.recruitment.repository.CompanyRepository;
import com.wanted.preonboarding.recruitment.repository.RecruitmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@Import({TestConfig.class})
@DisplayName("채용공고 Service 클래스 테스트")
@SpringBootTest
class RecruitmentServiceTest {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private RecruitmentRepository recruitmentRepository;
    @Autowired
    private RecruitmentService recruitmentService;

    Company company;

    @BeforeEach
    void getTestCompany() {
        company = companyRepository.findAll().get(0);
    }

    @Test
    @DisplayName("채용공고 저장 테스트")
    void addRecruitmentTest() {

        //given
        int originalRepositorySize = recruitmentRepository.findAll().size();
        RecruitmentRegisterDto recruitmentRegisterDto = RecruitmentRegisterDto.builder()
                .position("백엔드 주니어 개발자")
                .companyId(company.getId())
                .signingBonus(5_000_000)
                .techStack("Spring")
                .content("많은 지원 바랍니다.")
                .build();

        //when
        recruitmentService.addRecruitment(recruitmentRegisterDto);

        //then
        assertThat(recruitmentRepository.findAll().size()).isEqualTo(originalRepositorySize + 1);
    }

    @Test
    @DisplayName("채용공고 수정 테스트")
    void modifyRecruitmentTest() {
        //given
        RecruitmentRegisterDto recruitmentRegisterDto = RecruitmentRegisterDto.builder()
                .position("백엔드 주니어 개발자")
                .companyId(company.getId())
                .signingBonus(5_000_000)
                .techStack("Spring")
                .content("많은 지원 바랍니다.")
                .build();
        Long savedRecruitmentId = recruitmentService.addRecruitment(recruitmentRegisterDto);
        String originalPosition = recruitmentRegisterDto.getPosition();

        //when
        RecruitmentUpdateDto recruitmentUpdateDto = RecruitmentUpdateDto.builder()
                .position("백엔드 신입 개발자")
                .signingBonus(0)
                .techStack(Tech.DJANGO.getTechStack())
                .content("")
                .build();
        recruitmentService.modifyRecruitment(recruitmentUpdateDto, savedRecruitmentId);

        //then
        assertThat(recruitmentRepository.findById(savedRecruitmentId).get().getPosition())
                .isNotEqualTo(originalPosition);
    }

    @Test
    @DisplayName("채용공고 삭제 테스트")
    void deleteRecruitmentTest() {
        //given
        RecruitmentRegisterDto recruitmentRegisterDto = RecruitmentRegisterDto.builder()
                .position("백엔드 주니어 개발자")
                .companyId(company.getId())
                .signingBonus(5_000_000)
                .techStack("Spring")
                .content("많은 지원 바랍니다.")
                .build();
        Long savedRecruitmentId = recruitmentService.addRecruitment(recruitmentRegisterDto);
        int originalSize = recruitmentRepository.findAll().size();

        //when
        recruitmentService.removeRecruitment(savedRecruitmentId);

        //then
        assertThat(recruitmentRepository.findAll().size()).isEqualTo(originalSize - 1);
    }

}