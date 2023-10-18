package com.wanted.preonboarding.applicant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicantApplyingDto {

    private Long applicantId;
    private Long recruitmentId;

}
