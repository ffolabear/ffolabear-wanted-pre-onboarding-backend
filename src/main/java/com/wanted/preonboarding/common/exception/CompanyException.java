package com.wanted.preonboarding.common.exception;

import com.wanted.preonboarding.common.code.CompanyErrorCode;

public class CompanyException extends DefaultException{
    public CompanyException(CompanyErrorCode code) {
        super(code);
    }
}
