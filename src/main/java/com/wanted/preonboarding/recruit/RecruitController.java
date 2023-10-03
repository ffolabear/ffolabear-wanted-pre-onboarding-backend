package com.wanted.preonboarding.recruit;

import com.wanted.preonboarding.common.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//채용공고 컨트롤러
@RestController("/recruitment")
public class RecruitController {

    //요구사항 1번 - 채용공고 등록
    @PostMapping
    public void registerRecruitment(RecruitRegisterDto recruitRegisterDto) {

    }

    //요구사항 2번 - 채용공고 수정
    @PostMapping("/{recruitmentId}")
    public ResponseEntity<CommonResponse> updateRecruitment(RecruitUpdateDto recruitUpdateDto,
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
    public ResponseEntity<CommonResponse> searchRecruitment() {
        return null;
    }



}
