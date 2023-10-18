package com.wanted.preonboarding.applicant;

import com.wanted.preonboarding.applicant.dto.ApplicantApplyingDto;
import com.wanted.preonboarding.applicant.entity.Applicant;
import com.wanted.preonboarding.applicant.repository.ApplicantRepository;
import com.wanted.preonboarding.applicant.repository.ApplicationRepository;
import com.wanted.preonboarding.common.Tech;
import com.wanted.preonboarding.config.TestDataInit;
import com.wanted.preonboarding.recruitment.dto.RecruitmentDetailResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentSearchRequestDto;
import com.wanted.preonboarding.recruitment.entity.Recruitment;
import com.wanted.preonboarding.recruitment.repository.RecruitmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@DisplayName("지원자 Service 클래스 테스트")
@SpringBootTest
class ApplicantServiceTest {

    @Autowired
    private RecruitmentRepository recruitmentRepository;
    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private TestDataInit testDataInit;

    @BeforeEach
    void setUp() {
        testDataInit.createDummyDataForApplicantTest();
    }

    @Test
    @DisplayName("모든 채용공고 조회 테스트")
    void findAllRecruitmentTest() {
        //given
        int fromApplicantService = applicantService.findAllRecruitment().size();
        int fromRecruitmentRepository = recruitmentRepository.findAll().size();

        //then
        assertThat(fromApplicantService).isEqualTo(fromRecruitmentRepository);
    }

    @Nested
    @DisplayName("채용공고 검색 테스트")
    class searchRecruitmentTest {

        @DisplayName("직무로 검색 통과 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"주니어", "주니어 ", "시니어", " 시니어"})
        void searchByPositionSuccessTest(String position) {
            //given
            List<RecruitmentResponseDto> findRecruitment = applicantService.searchRecruitment(RecruitmentSearchRequestDto.builder()
                    .position(position)
                    .build());
            //then
            assertThat(findRecruitment.stream()
                    .allMatch(recruitmentResponseDto -> recruitmentResponseDto.getPosition().contains(position)))
                    .isTrue();
        }

        @DisplayName("직무로 검색 실패 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"123", "신입", "초보", "고수"})
        void searchByPositionFailTest(String position) {
            //given
            List<RecruitmentResponseDto> findRecruitment = applicantService.searchRecruitment(RecruitmentSearchRequestDto.builder()
                    .position(position)
                    .build());
            //then
            assertThat(findRecruitment).isEmpty();
        }

        @DisplayName("회사이름으로 검색 성공 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"네이버", "카카오", "라인", "쿠팡", "우아한형제들", "원티드"})
        void searchByCompanySuccessTest(String company) {
            //given
            List<RecruitmentResponseDto> findRecruitment = applicantService.searchRecruitment(RecruitmentSearchRequestDto.builder()
                    .companyName(company)
                    .build());

            //then
            assertThat(findRecruitment.stream()
                    .allMatch(dto -> dto.getCompanyName().contains(company)))
                    .isTrue();
        }

        @DisplayName("회사이름으로 검색 실패 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"123", "abc", " ", "사과", "사과123"})
        void searchByCompanyFailTest(String company) {
            //given
            List<RecruitmentResponseDto> findRecruitment = applicantService.searchRecruitment(RecruitmentSearchRequestDto.builder()
                    .companyName(company)
                    .build());
            //then
            assertThat(findRecruitment.stream()
                    .noneMatch(dto -> dto.getCompanyName().contains(company)))
                    .isTrue();
        }

        @DisplayName("채용보상금으로 검색 성공 테스트")
        @ParameterizedTest
        @ValueSource(ints = {100_000, 150_000, 200_000})
        void searchBySigningBonusSuccessTest(int signingBonus) {

            //given
            List<RecruitmentResponseDto> findRecruitment = applicantService.searchRecruitment(RecruitmentSearchRequestDto.builder()
                    .signingBonus(signingBonus)
                    .build());
            //then
            assertThat(findRecruitment.stream()
                    .allMatch(dto -> dto.getSigningBonus() >= signingBonus))
                    .isTrue();
        }

        @DisplayName("채용보상금으로 검색 실패 테스트")
        @ParameterizedTest
        @ValueSource(ints = {1_000_000, 1_500_000, 2_000_000})
        void searchBySigningBonusFailTest(int signingBonus) {

            //given
            List<RecruitmentResponseDto> findRecruitment = applicantService.searchRecruitment(RecruitmentSearchRequestDto.builder()
                    .signingBonus(signingBonus)
                    .build());
            //then
            assertThat(findRecruitment.stream()
                    .noneMatch(dto -> dto.getSigningBonus() >= signingBonus))
                    .isTrue();
        }

        @DisplayName("기술스택으로 검색 성공 테스트")
        @ParameterizedTest
        @EnumSource
        void searchByTechStackSuccessTest(Tech tech) {
            //given
            List<RecruitmentResponseDto> findRecruitment = applicantService.searchRecruitment(RecruitmentSearchRequestDto.builder()
                    .techStack(tech.getTechStack())
                    .build());
            //then
            assertThat(findRecruitment.stream()
                    .allMatch(dto -> dto.getTechStack().equals(tech.getTechStack())))
                    .isTrue();
        }

        @DisplayName("기술스택으로 검색 실패 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"123", "a", "가나다"})
        void searchByTechStackFailTest(String tech) {
            //given
            List<RecruitmentResponseDto> findRecruitment = applicantService.searchRecruitment(RecruitmentSearchRequestDto.builder()
                    .techStack(tech)
                    .build());
            //then
            assertThat(findRecruitment.stream()
                    .noneMatch(dto -> dto.getTechStack().equals(tech)))
                    .isTrue();
        }

        @Test
        @DisplayName("모든 조건으로 검색")
        void searchByMultipleOptionTest() {
            //given
            Recruitment existingRecruitment = recruitmentRepository.findAll().get(0);
            List<RecruitmentResponseDto> findRecruitment = applicantService.searchRecruitment(RecruitmentSearchRequestDto.builder()
                    .position(existingRecruitment.getPosition())
                    .companyName(existingRecruitment.getCompany().getName())
                    .signingBonus(existingRecruitment.getSigningBonus())
                    .techStack(existingRecruitment.getTechStack().getTechStack())
                    .build());

            //then
            assertThat(findRecruitment.stream().allMatch(dto ->
                    dto.getPosition().equals(existingRecruitment.getPosition()) &&
                            dto.getCompanyName().equals(existingRecruitment.getCompany().getName()) &&
                            dto.getSigningBonus().equals(existingRecruitment.getSigningBonus()) &&
                            dto.getTechStack().equals(existingRecruitment.getTechStack().getTechStack())))
                    .isTrue();
        }
    }

    @Test
    @DisplayName("채용공고 상세 내용 테스트")
    void findRecruitmentDetailTest() {
        Recruitment existingRecruitment = recruitmentRepository.findAll().get(5);
        RecruitmentDetailResponseDto recruitmentDetail = applicantService.findRecruitmentDetail(existingRecruitment.getId());
        System.out.println(existingRecruitment);
        System.out.println(recruitmentDetail);
        assertThat(recruitmentDetail.getContent()).isEqualTo(existingRecruitment.getContent());
    }

    @Test
    @DisplayName("채용공고 지원 테스트")
    void applyingRecruitmentTest() {
        Recruitment recruitment = recruitmentRepository.findAll().get(2);
        Applicant applicant = applicantRepository.findAll().get(2);

        int originalSize = applicationRepository.findAll().size();

        applicantService.applyingRecruitment(ApplicantApplyingDto.builder()
                .applicantId(applicant.getId())
                .recruitmentId(recruitment.getId())
                .build());
        assertThat(applicationRepository.findAll().size()).isEqualTo(originalSize + 1);
    }

}