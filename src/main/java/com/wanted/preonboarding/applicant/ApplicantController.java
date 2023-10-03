package com.wanted.preonboarding.applicant;

import com.wanted.preonboarding.common.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/applicant")
public class ApplicantController {

    //요구사항 5번 - 채용공고 상세내용 조회
    @GetMapping("/{recruitmentId}")
    public ResponseEntity<CommonResponse> getRecruitmentDetail(@PathVariable Long recruitmentId) {
        return null;
    }

    //요구사항 6번 - 채용공고 지원
    @PostMapping("/{recruitmentId}")
    public ResponseEntity<CommonResponse> applyRecruitment(@PathVariable Long recruitmentId) {
        return null;
    }

}
