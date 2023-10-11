package com.wanted.preonboarding.recruitment.repository;

import com.wanted.preonboarding.recruitment.dto.RecruitmentSearchRequestDto;
import com.wanted.preonboarding.recruitment.entity.Recruitment;

import java.util.List;

public interface QuerydslRecruitmentRepositoryCustom {

    List<Recruitment> findRecruitmentByCondition(RecruitmentSearchRequestDto recruitmentSearchRequestDto);

}
