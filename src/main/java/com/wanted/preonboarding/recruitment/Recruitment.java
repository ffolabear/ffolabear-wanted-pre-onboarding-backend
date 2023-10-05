package com.wanted.preonboarding.recruitment;

//채용공고 엔티티

import com.wanted.preonboarding.applicant.Application;
import com.wanted.preonboarding.common.Tech;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Recruitment {

    @Id
    @Column(name = "recruitment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private String position;
    @Column(name = "signing_bonus")
    private Integer signingBonus;
    @Column(name = "tech_stack")
    private Tech techStack;
    private String content;
    @OneToMany(mappedBy = "recruitment")
    private List<Application> application;
    private String isDeleted;

}
