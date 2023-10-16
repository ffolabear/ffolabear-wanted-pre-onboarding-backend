package com.wanted.preonboarding.recruitment.entity;

//채용공고 엔티티

import com.wanted.preonboarding.applicant.entity.Application;
import com.wanted.preonboarding.common.BaseTime;
import com.wanted.preonboarding.common.Tech;
import com.wanted.preonboarding.recruitment.dto.RecruitmentDetailResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentUpdateDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Recruitment extends BaseTime {

    @Id
    @Column(name = "recruitment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "signing_bonus")
    @ColumnDefault("0")
    private Integer signingBonus;

    @Column(name = "tech_stack")
    @Enumerated(EnumType.STRING)
    private Tech techStack;

    @Column(nullable = false, length = 3000)
    private String content;

    @OneToMany(mappedBy = "recruitment")
    private final List<Application> application = new ArrayList<>();

    @Column(name = "is_deleted")
    @ColumnDefault("'N'")
    private String isDeleted;

    public Recruitment modifyRecruitment(Recruitment originalRecruitment, RecruitmentUpdateDto recruitmentUpdateDto) {
        originalRecruitment.setPosition(recruitmentUpdateDto.getPosition());
        originalRecruitment.setSigningBonus(recruitmentUpdateDto.getSigningBonus());
        originalRecruitment.setTechStack(Tech.isTechExist(recruitmentUpdateDto.getTechStack()));
        originalRecruitment.setContent(recruitmentUpdateDto.getContent());
        return originalRecruitment;
    }

    public RecruitmentResponseDto toRecruitment(Recruitment recruitment) {
        Company company = recruitment.getCompany();
        return RecruitmentResponseDto.builder()
                .id(recruitment.id)
                .companyName(company.getName())
                .countryCountry(company.getRegion())
                .countryRegion(company.getRegion())
                .signingBonus(recruitment.signingBonus)
                .techStack(recruitment.techStack.getTechStack())
                .build();
    }

    public RecruitmentDetailResponseDto toSearchedRecruitment(
            Recruitment recruitment, List<RecruitmentResponseDto> companyRecruitments) {
        Company company = recruitment.getCompany();
        return RecruitmentDetailResponseDto.builder()
                .id(recruitment.getId())
                .companyName(company.getName())
                .companyRegion(company.getRegion())
                .position(recruitment.getPosition())
                .signingBonus(recruitment.getSigningBonus())
                .techStack(recruitment.techStack.getTechStack())
                .content(recruitment.getContent())
                .companyRecruitments(companyRecruitments)
                .build();
    }
}
