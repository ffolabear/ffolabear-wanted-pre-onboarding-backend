package com.wanted.preonboarding.recruitment.dto;

import com.wanted.preonboarding.common.Tech;
import com.wanted.preonboarding.recruitment.entity.Company;
import com.wanted.preonboarding.recruitment.entity.Recruitment;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

//채용공고 등록 데이터 dto
@Getter
@Builder
public class RecruitmentRegisterDto {

    private Long companyId;

    @NotBlank(message = "등록할 채용공고의 포지션을 입력해주세요.")
    @Length(max = 50, message = "길이 제한이 초과되었습니다.")
    private String position;

    private Integer signingBonus;

    private String techStack;

    @NotBlank(message = "등록할 채용공고의 내용을 입력해주세요.")
    @Length(max = 3000, message = "길이 제한이 초과되었습니다.")
    private String content;

    public Recruitment toRecruitment(Company company) {
        return Recruitment.builder()
                .company(company)
                .position(this.position)
                .signingBonus(this.signingBonus)
                .techStack(Tech.valueOf(this.techStack))
                .content(this.content)
                .build();
    }

}
