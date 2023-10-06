package com.wanted.preonboarding.common.exception;

import com.wanted.preonboarding.common.code.Code;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DefaultException extends RuntimeException {
    private final Code code;
}