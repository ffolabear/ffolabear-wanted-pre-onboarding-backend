package com.wanted.preonboarding.recruitment.entity;

//채용공고 엔티티

import com.wanted.preonboarding.applicant.entity.Application;
import com.wanted.preonboarding.common.Tech;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;

@Setter
@Getter
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Recruitment {

    @Id
    @Column(name = "recruitment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    private String position;

    @Column(name = "signing_bonus")
    @ColumnDefault("0")
    private Integer signingBonus;

    @Column(name = "tech_stack")
    @Enumerated(EnumType.STRING)
    private Tech techStack;

    private String content;

    @OneToMany(mappedBy = "recruitment")
    private List<Application> application;

    @Column(name = "is_deleted")
    @ColumnDefault("'N'")
    private String isDeleted;

}
