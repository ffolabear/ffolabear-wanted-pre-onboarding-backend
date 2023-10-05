package com.wanted.preonboarding.recruitment.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class Company {

    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String country;

    private String region;

    @Column(name = "is_deleted")
    @ColumnDefault("'N'")
    private String isDeleted;

}
