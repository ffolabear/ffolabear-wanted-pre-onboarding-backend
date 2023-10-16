package com.wanted.preonboarding.recruitment;

import com.wanted.preonboarding.common.CommonResponse;
import com.wanted.preonboarding.common.code.CommonCode;
import com.wanted.preonboarding.recruitment.dto.RecruitmentRegisterDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


//채용공고 컨트롤러
@RequiredArgsConstructor
@RequestMapping(("/recruitment"))
@RestController
public class RecruitmentController {

    private final RecruitmentService recruitService;

    //요구사항 1번 - 채용공고 등록
    @PostMapping
    public ResponseEntity<CommonResponse> postRecruitment(@RequestBody RecruitmentRegisterDto recruitRegisterDto) {
        Long createdId = recruitService.addRecruitment(recruitRegisterDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{recruitmentId}")
                .buildAndExpand(createdId)
                .toUri();
        return ResponseEntity.created(location).body(CommonResponse.toResponse(CommonCode.CREATED, createdId));
    }

    //요구사항 2번 - 채용공고 수정
    @PutMapping("/{recruitmentId}")
    public ResponseEntity<CommonResponse> putRecruitment(@RequestBody RecruitmentUpdateDto recruitUpdateDto,
                                                         @PathVariable Long recruitmentId) {
        Long modifiedId = recruitService.modifyRecruitment(recruitUpdateDto, recruitmentId);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .build()
                .toUri();

        return ResponseEntity.created(location).body(CommonResponse.toResponse(CommonCode.CREATED, modifiedId));
    }

    //요구사항 3번 - 채용공고 삭제
    @DeleteMapping("/{recruitmentId}")
    public ResponseEntity<CommonResponse> deleteRecruitment(@PathVariable Long recruitmentId) {
        recruitService.removeRecruitment(recruitmentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(CommonResponse.toResponse(CommonCode.NO_CONTENT));
    }

}
