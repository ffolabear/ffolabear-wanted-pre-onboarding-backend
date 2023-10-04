package com.wanted.preonboarding.recruitment;

import com.wanted.preonboarding.common.CommonResponse;
import com.wanted.preonboarding.recruitment.dto.RecruitmentRegisterDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentSearchRequestDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//채용공고 컨트롤러
@RequiredArgsConstructor
@RestController("/recruitment")
public class RecruitmentController {

    private final RecruitmentService recruitService;

    //요구사항 1번 - 채용공고 등록
    @PostMapping
    public void postRecruitment(RecruitmentRegisterDto recruitRegisterDto) {
        recruitService.addRecruitment(recruitRegisterDto);
    }

    //요구사항 2번 - 채용공고 수정
    @PutMapping("/{recruitmentId}")
    public ResponseEntity<CommonResponse> putRecruitment(RecruitmentUpdateDto recruitUpdateDto,
                                                         @PathVariable Long recruitmentId) {
        return null;
    }

    //요구사항 3번 - 채용공고 삭제
    @DeleteMapping("/{recruitmentId}")
    public ResponseEntity<CommonResponse> deleteRecruitment(@PathVariable Long recruitmentId) {
        return null;
    }

    //요구사항 4-1번 - 채용공고 목록 조회
    @GetMapping
    public ResponseEntity<CommonResponse> getRecruitment() {
        return null;
    }

    //요구사항 4-2번 - 채용공고 검색
    @GetMapping
    public ResponseEntity<CommonResponse> getSearchedRecruitment(RecruitmentSearchRequestDto recruitSearchRequestDto) {
        return null;
    }



}
