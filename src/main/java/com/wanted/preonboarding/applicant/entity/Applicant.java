package com.wanted.preonboarding.applicant.entity;

import com.wanted.preonboarding.common.BaseTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Applicant extends BaseTime {

    @Id
    @Column(name = "applicant_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "applicant")
    private Set<Application> applications;

    @Column(name = "is_deleted")
    @ColumnDefault("'N'")
    private String isDeleted;
}
