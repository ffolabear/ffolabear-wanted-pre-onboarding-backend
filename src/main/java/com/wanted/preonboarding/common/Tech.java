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

    private final String techStack;

    Tech(String techStack) {
        this.techStack = techStack;
    }

    public static Tech isTechExist(String query) {
        for (Tech tech : Tech.values()) {
            if (tech.techStack.equals(query)) {
                return tech;
            }
        }
        return Tech.ETC;
    }
}
