package com.wanted.preonboarding.recruitment.dto;

import lombok.Builder;

//채용공고 조회 dto
//채용공괴 조회 및 검색시 사용
@Builder
public class RecruitmentResponseDto {

    private Long id;
    private String companyName;
    private String countryCountry;
    private String countryRegion;
    private String position;
    private Integer signingBonus;
    private String techStack;

}
