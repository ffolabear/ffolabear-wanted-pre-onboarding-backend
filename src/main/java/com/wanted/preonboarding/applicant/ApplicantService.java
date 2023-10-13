package com.wanted.preonboarding.applicant;

import com.wanted.preonboarding.applicant.dto.ApplicantApplyingDto;
import com.wanted.preonboarding.applicant.entity.Applicant;
import com.wanted.preonboarding.applicant.entity.Application;
import com.wanted.preonboarding.applicant.repository.ApplicantRepository;
import com.wanted.preonboarding.applicant.repository.ApplicationRepository;
import com.wanted.preonboarding.common.code.ApplicantErrorCode;
import com.wanted.preonboarding.common.code.RecruitmentErrorCode;
import com.wanted.preonboarding.common.exception.ApplicantException;
import com.wanted.preonboarding.common.exception.RecruitmentException;
import com.wanted.preonboarding.recruitment.dto.RecruitmentDetailResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentSearchRequestDto;
import com.wanted.preonboarding.recruitment.entity.Recruitment;
import com.wanted.preonboarding.recruitment.repository.QuerydslRecruitmentRepositoryCustom;
import com.wanted.preonboarding.recruitment.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ApplicantService {

    private ApplicantRepository applicantRepository;
    private RecruitmentRepository recruitmentRepository;
    private ApplicationRepository applicationRepository;
    private QuerydslRecruitmentRepositoryCustom qRecruitmentRepository;

    public List<RecruitmentResponseDto> findAllRecruitment() {
        List<Recruitment> recruitments = recruitmentRepository.findAllByOrderByRegDateDesc();
        return recruitments.stream()
                .map(recruitment -> recruitment.toRecruitment(recruitment))
                .collect(Collectors.toList());
    }

    public List<RecruitmentResponseDto> searchRecruitment(RecruitmentSearchRequestDto recruitSearchRequestDto) {
        List<Recruitment> searchingRecruitment = qRecruitmentRepository.findRecruitmentByCondition(recruitSearchRequestDto);
        return searchingRecruitment.stream()
                .map(recruitment -> recruitment.toRecruitment(recruitment))
                .collect(Collectors.toList());
    }

    public RecruitmentDetailResponseDto findRecruitmentDetail(Long recruitmentId) {
        Recruitment findRecruitment = recruitmentRepository.findById(recruitmentId).orElseThrow(
                () -> new RejectedExecutionException(RecruitmentErrorCode.RECRUITMENT_NOT_FOUND.getMessage()));

        List<Recruitment> companyRecruitments = recruitmentRepository.findAllByCompany_Name(
                findRecruitment.getCompany().getName());

        List<RecruitmentResponseDto> convertedRecruitments = companyRecruitments.stream()
                .map(recruitment -> recruitment.toRecruitment(recruitment))
                .toList();

        return findRecruitment.toSearchedRecruitment(findRecruitment, convertedRecruitments);
    }

    public void applyingRecruitment(Long recruitmentId, ApplicantApplyingDto applicantApplyingDto) {
        Applicant applyingApplicant = applicantRepository.findById(applicantApplyingDto.getApplicantId()).orElseThrow(
                () -> new ApplicantException(ApplicantErrorCode.APPLICANT_NOT_FOUND));
        Recruitment applyingRecruitment = recruitmentRepository.findById(recruitmentId).orElseThrow(
                () -> new RecruitmentException(RecruitmentErrorCode.RECRUITMENT_NOT_FOUND));
        Application appliedApplication = Application.builder()
                .applicant(applyingApplicant)
                .recruitment(applyingRecruitment)
                .build();
        applicationRepository.save(appliedApplication);
    }

}
