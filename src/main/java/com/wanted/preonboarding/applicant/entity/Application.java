package com.wanted.preonboarding.applicant.entity;

import com.wanted.preonboarding.recruitment.entity.Recruitment;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class Application {

    @Id
    @Column(name = "application_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruitment_id")
    private Recruitment recruitment;

    @Column(name = "is_deleted")
    @ColumnDefault("'N'")
    private String isDeleted;
}
