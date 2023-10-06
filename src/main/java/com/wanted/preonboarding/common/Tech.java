package com.wanted.preonboarding.common;

import lombok.Getter;

@Getter
public enum Tech {

    JAVA("Java"),
    SPRING("Spring"),
    PYTHON("Python"),
    DJANGO("Django"),
    JAVASCRIPT("Javascript"),
    NODEJS("Node.js"),
    ETC("기타");

    private final String tech;

    Tech(String tech) {
        this.tech = tech;
    }
}
