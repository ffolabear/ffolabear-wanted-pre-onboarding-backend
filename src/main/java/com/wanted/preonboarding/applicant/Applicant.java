package com.wanted.preonboarding.applicant;

import jakarta.persistence.*;

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

}
