package com.wanted.preonboarding.applicant.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.HashSet;

@Entity
public class Applicant {

    @Id
    @Column(name = "applicant_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "applicant")
    private HashSet<Application> applications = new HashSet<>();

    @Column(name = "is_deleted")
    @ColumnDefault("'N'")
    private String isDeleted;
}
