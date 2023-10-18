package com.wanted.preonboarding.common.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum RecruitmentErrorCode implements Code {

    RECRUITMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "공고를 찾을 수 없습니다.");

    private final HttpStatus code;
    private final String message;

    RecruitmentErrorCode(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }
}
