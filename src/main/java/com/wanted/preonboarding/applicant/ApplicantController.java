package com.wanted.preonboarding.applicant;

import com.wanted.preonboarding.applicant.dto.ApplicantApplyingDto;
import com.wanted.preonboarding.common.CommonResponse;
import com.wanted.preonboarding.common.code.CommonCode;
import com.wanted.preonboarding.recruitment.dto.RecruitmentDetailResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController("/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;

    @GetMapping("/recruitmentList")
    public ResponseEntity<CommonResponse> getAllRecruitment() {
        List<RecruitmentResponseDto> allRecruitment = applicantService.findAllRecruitment();
        return ResponseEntity.ok(CommonResponse.toResponse(CommonCode.OK, allRecruitment));
    }

    //요구사항 4-2번 - 채용공고 검색
    @GetMapping("/search")
    public ResponseEntity<CommonResponse> getSearchedRecruitment(RecruitmentSearchRequestDto recruitSearchRequestDto) {
        List<RecruitmentResponseDto> searchingRecruitment = applicantService.searchRecruitment(recruitSearchRequestDto);
        return ResponseEntity.ok(CommonResponse.toResponse(CommonCode.OK, searchingRecruitment));
    }

    //요구사항 5번 - 채용공고 상세내용 조회
    @GetMapping("/{recruitmentId}")
    public ResponseEntity<CommonResponse> getRecruitmentDetail(@PathVariable Long recruitmentId) {
        RecruitmentDetailResponseDto recruitmentDetail = applicantService.findRecruitmentDetail(recruitmentId);
        return ResponseEntity.ok(CommonResponse.toResponse(CommonCode.OK, recruitmentDetail));
    }

    //요구사항 6번 - 채용공고 지원
    @PostMapping("/{recruitmentId}")
    public ResponseEntity<CommonResponse> postApplyingRecruitment(@PathVariable Long recruitmentId, ApplicantApplyingDto applicantApplyingDto) {
        applicantService.applyingRecruitment(recruitmentId,applicantApplyingDto);
        return ResponseEntity.ok(CommonResponse.toResponse(CommonCode.OK));
    }

}
