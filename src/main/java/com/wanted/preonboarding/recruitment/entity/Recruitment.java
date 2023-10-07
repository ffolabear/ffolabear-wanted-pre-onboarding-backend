package com.wanted.preonboarding.recruitment.entity;

//채용공고 엔티티

import com.wanted.preonboarding.applicant.entity.Application;
import com.wanted.preonboarding.common.BaseTime;
import com.wanted.preonboarding.common.Tech;
import com.wanted.preonboarding.recruitment.dto.RecruitmentRegisterDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
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

}
