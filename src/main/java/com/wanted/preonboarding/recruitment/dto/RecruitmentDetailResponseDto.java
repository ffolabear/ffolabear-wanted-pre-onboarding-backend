package com.wanted.preonboarding.recruitment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

//채용공고 상세 데이터 dto

@ToString
@Getter
@Builder
public class RecruitmentDetailResponseDto {

    private Long id;
    private String companyName;
    private String companyCountry;
    private String companyRegion;
    private String position;
    private Integer signingBonus;
    private String techStack;
    private String content;
    private List<RecruitmentResponseDto> companyRecruitments;

}
