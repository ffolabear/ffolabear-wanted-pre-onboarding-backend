package com.wanted.preonboarding.applicant;

import com.wanted.preonboarding.common.CommonResponse;
import com.wanted.preonboarding.recruit.dto.ApplicantApplyingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;

    //요구사항 5번 - 채용공고 상세내용 조회
    @GetMapping("/{recruitmentId}")
    public ResponseEntity<CommonResponse> getRecruitmentDetail(@PathVariable Long recruitmentId) {
        return null;
    }

    //요구사항 6번 - 채용공고 지원
    @PostMapping("/{recruitmentId}")
    public ResponseEntity<CommonResponse> postApplyingRecruitment(@PathVariable Long recruitmentId, ApplicantApplyingDto applicantApplyingDto) {
        return null;
    }

}
