package com.wanted.preonboarding.common;

import org.springframework.http.HttpStatus;

public interface Code {
    String name();
    HttpStatus getCode();
    String getMessage();
}