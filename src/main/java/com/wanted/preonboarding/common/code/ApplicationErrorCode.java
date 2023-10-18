package com.wanted.preonboarding.common.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApplicationErrorCode implements Code {

    APPLIED_APPLICATION(HttpStatus.BAD_REQUEST, "이미 지원한 공고입니다.");

    private final HttpStatus code;
    private final String message;

    ApplicationErrorCode(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }
}
