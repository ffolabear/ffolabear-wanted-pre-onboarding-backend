package com.wanted.preonboarding.common.exception;

import com.wanted.preonboarding.common.code.Code;

public class ApplicantException extends DefaultException {

    public ApplicantException(Code code) {
        super(code);
    }
}
