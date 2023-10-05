package com.wanted.preonboarding.recruitment;

import jakarta.persistence.*;

@Entity
public class Company {

    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String country;
    private String region;
    private String isDeleted;

}
