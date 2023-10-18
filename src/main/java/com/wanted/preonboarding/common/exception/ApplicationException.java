package com.wanted.preonboarding.common.exception;


import com.wanted.preonboarding.common.code.Code;

public class ApplicationException extends DefaultException {
    public ApplicationException(Code code) {
        super(code);
    }
}
