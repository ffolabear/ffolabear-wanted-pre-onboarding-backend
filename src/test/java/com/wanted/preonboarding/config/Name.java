package com.wanted.preonboarding.config;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Getter
public enum Name {

    COMPANY(Arrays.asList("네이버", "카카오", "라인", "쿠팡", "우아한형제들", "원티드")),
    POSITION(Arrays.asList("주니어 백엔드 개발자", "시니어 백엔드 개발자", "주니어 프론트엔드 개발자", "시니어 프론트엔드 개발자",
            "주니어 DBA", "시니어 DBA")),
    APPLICANT(Arrays.asList("무지", "죠르디", "라이언", "어피치", "우아한형제들", "콘")),
    REGION(Arrays.asList("성남시 분당구", "서울시 구로구", "서울 금천구", "서울시 강남구", "서울시 송파구"));

    private final List<String> nameList;

    Name(List<String> nameList) {
        this.nameList = nameList;
    }

    public String getRandomName() {
        Collections.shuffle(nameList);
        return nameList.get(0);
    }

}
