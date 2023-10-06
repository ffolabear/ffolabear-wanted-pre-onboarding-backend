package com.wanted.preonboarding.common.code;

import org.springframework.http.HttpStatus;

public interface Code {
    String name();
    HttpStatus getCode();
    String getMessage();
}