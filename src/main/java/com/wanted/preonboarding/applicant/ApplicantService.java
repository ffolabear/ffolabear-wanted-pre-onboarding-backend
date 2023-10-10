package com.wanted.preonboarding.applicant;

import com.wanted.preonboarding.applicant.dto.ApplicantApplyingDto;
import com.wanted.preonboarding.recruitment.dto.ApplyRecruitmentResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentDetailResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentSearchRequestDto;
import com.wanted.preonboarding.recruitment.entity.Recruitment;
import com.wanted.preonboarding.recruitment.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ApplicantService {

    private RecruitmentRepository recruitmentRepository;

    public List<RecruitmentResponseDto> findAllRecruitment() {
        List<Recruitment> recruitments = recruitmentRepository.findAllByOrderByRegDateDesc();
        return recruitments.stream()
                .map(recruitment -> recruitment.toRecruitment(recruitment))
                .collect(Collectors.toList());
    }

    public RecruitmentResponseDto searchRecruitment(RecruitmentSearchRequestDto recruitSearchRequestDto) {
        return null;
    }

    public RecruitmentDetailResponseDto findRecruitmentDetail(Long recruitmentId) {
        return null;
    }

    public ApplyRecruitmentResponseDto applyingRecruitment(Long recruitmentId, ApplicantApplyingDto applicantApplyingDto) {
        return null;
    }

}
