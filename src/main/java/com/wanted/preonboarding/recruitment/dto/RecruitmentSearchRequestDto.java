package com.wanted.preonboarding.recruitment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@Builder
public class RecruitmentSearchRequestDto {

    private String position;
    private String companyName;
    private Integer signingBonus;
    private String techStack;
}
