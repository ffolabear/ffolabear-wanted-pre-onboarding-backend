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

import static com.wanted.preonboarding.config.Name.*;

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

    private void createCompanyDummyData() {
        company = Company.builder()
                .name(COMPANY.getRandomName())
                .country("대한민국")
                .region(REGION.getRandomName())
                .build();
        companyRepository.save(company);
    }

     private void createRecruitmentDummyData() {
        recruitment = Recruitment.builder()
                .position(POSITION.getRandomName())
                .company(company)
                .signingBonus(500_000)
                .techStack(Tech.isTechExist("Spring"))
                .content("많은 지원바랍니다.")
                .build();
        recruitmentRepository.save(recruitment);
    }

    private void createApplicantDummyData() {
        applicant = Applicant.builder()
                .name(APPLICANT.getRandomName())
                .build();
        applicantRepository.save(applicant);
    }

    private void createApplicationDummyData() {
        application = Application.builder()
                .applicant(applicant)
                .recruitment(recruitment)
                .build();
        applicationRepository.save(application);
    }

    public void createDummyDataForRecruitmentTest() {
        createCompanyDummyData();
        createRecruitmentDummyData();
    }

    public void createDummyDataForApplicantTest() {
        createCompanyDummyData();
        createRecruitmentDummyData();
        createApplicantDummyData();
        createApplicationDummyData();
    }

}
