package com.wanted.preonboarding.applicant;

import com.wanted.preonboarding.applicant.dto.ApplicantApplyingDto;
import com.wanted.preonboarding.common.CommonResponse;
import com.wanted.preonboarding.common.code.CommonCode;
import com.wanted.preonboarding.recruitment.dto.RecruitmentDetailResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping(("/applicant"))
@RestController
public class ApplicantController {

    private final ApplicantService applicantService;

    //요구사항 4-1번 - 채용공고 목록 조회
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
    public ResponseEntity<CommonResponse> postApplyingRecruitment(@RequestBody ApplicantApplyingDto applicantApplyingDto) {
        applicantService.applyingRecruitment(applicantApplyingDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .build()
                .toUri();
        return ResponseEntity.created(location).body(CommonResponse.toResponse(CommonCode.CREATED));
    }

}
