package com.wanted.preonboarding.common.exception;

import com.wanted.preonboarding.common.code.Code;

public class RecruitmentException extends DefaultException {

    public RecruitmentException(Code code) {
        super(code);
    }
}
