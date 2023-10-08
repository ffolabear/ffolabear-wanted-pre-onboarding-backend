package com.wanted.preonboarding.recruitment.repository;

import com.wanted.preonboarding.common.Tech;
import com.wanted.preonboarding.recruitment.entity.Company;
import com.wanted.preonboarding.recruitment.entity.Recruitment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("채용공고 Repository 클래스 테스트")
@DataJpaTest
class CompanyRepositoryTest {

    @Autowired
    private RecruitmentRepository recruitmentRepository;
    @Autowired
    private CompanyRepository companyRepository;

    Company company;
    @BeforeEach
    void getTestCompany() {
        Company testcompany = Company.builder()
                .name("원티드")
                .country("대한민국")
                .region("서울시 송파구")
                .build();
        companyRepository.save(testcompany);
        company = companyRepository.findAll().get(0);
    }

    @Test
    @DisplayName("채용공고 등록 테스트")
    void saveRecruitmentTest() {

        Company company = companyRepository.findAll().get(0);
        //given
        Recruitment recruitment = Recruitment.builder()
                .position("백엔드 주니어 개발자")
                .company(company)
                .signingBonus(500_000)
                .techStack(Tech.SPRING)
                .content("많은 지원 바랍니다.")
                .build();

        //when
        int beforeSave = recruitmentRepository.findAll().size();
        recruitmentRepository.save(recruitment);

        //then
        assertThat(recruitmentRepository.findAll().size()).isEqualTo(beforeSave + 1);
    }

    @Test
    @DisplayName("채용공고 수정 테스트")
    void saveModifiedRecruitment() {

        //given
        Recruitment recruitment = Recruitment.builder()
                .position("백엔드 주니어 개발자")
                .company(company)
                .signingBonus(500_000)
                .techStack(Tech.SPRING)
                .content("많은 지원 바랍니다.")
                .build();
        recruitmentRepository.save(recruitment);

        //when
        Recruitment findRecruitment = recruitmentRepository.findByCompany_Name("원티드");
        String originalPositionName = findRecruitment.getPosition();
        recruitment.setPosition("프론트엔드 주니어 개발자");

        //then
        assertThat(recruitment.getPosition()).isNotEqualTo(originalPositionName);
    }

}