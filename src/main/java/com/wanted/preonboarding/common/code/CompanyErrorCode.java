package com.wanted.preonboarding.common.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CompanyErrorCode implements Code {

    COMPANY_NOT_FOUND(HttpStatus.NOT_FOUND, "회사를 찾을 수 없습니다.");

    private final HttpStatus code;
    private final String message;

    CompanyErrorCode(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }
}
