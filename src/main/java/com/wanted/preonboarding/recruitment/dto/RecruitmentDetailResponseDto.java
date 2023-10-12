package com.wanted.preonboarding.recruitment.dto;

import com.wanted.preonboarding.common.Tech;
import lombok.Builder;

import java.util.List;

//채용공고 상세 데이터 dto
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
