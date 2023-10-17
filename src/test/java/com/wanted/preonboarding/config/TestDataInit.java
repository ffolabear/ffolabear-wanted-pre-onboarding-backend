package com.wanted.preonboarding.config;

import com.wanted.preonboarding.applicant.entity.Applicant;
import com.wanted.preonboarding.applicant.entity.Application;
import com.wanted.preonboarding.applicant.repository.ApplicantRepository;
import com.wanted.preonboarding.applicant.repository.ApplicationRepository;
import com.wanted.preonboarding.common.Tech;
import com.wanted.preonboarding.recruitment.entity.Company;
import com.wanted.preonboarding.recruitment.entity.Recruitment;
import com.wanted.preonboarding.recruitment.repository.CompanyRepository;
import com.wanted.preonboarding.recruitment.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Component
public class TestDataInit {

    private final CompanyRepository companyRepository;
    private final RecruitmentRepository recruitmentRepository;
    private final ApplicantRepository applicantRepository;
    private final ApplicationRepository applicationRepository;
    Company company;
    Recruitment recruitment;
    Applicant applicant;
    Application application;

    public void createCompanyDummyData() {
        company = Company.builder()
                .name("원티드")
                .country("대한민국")
                .region("서울시 송파구")
                .build();
        companyRepository.save(company);
    }

     public void createRecruitmentDummyData() {
        recruitment = Recruitment.builder()
                .position("주니어 백엔드 개발자")
                .company(company)
                .signingBonus(500_000)
                .techStack(Tech.isTechExist("Spring"))
                .content("많은 지원바랍니다.")
                .build();
        recruitmentRepository.save(recruitment);
    }

    void createApplicantDummyData() {
        applicant = Applicant.builder()
                .name("김원티드")
                .build();
        applicantRepository.save(applicant);
    }

    public void createApplicationDummyData() {
        application = Application.builder()
                .applicant(applicant)
                .recruitment(recruitment)
                .build();
        applicationRepository.save(application);
    }

}
