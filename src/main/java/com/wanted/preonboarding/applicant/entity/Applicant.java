package com.wanted.preonboarding.applicant.entity;

import com.wanted.preonboarding.common.BaseTime;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Getter
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

    @Builder.Default
    @OneToMany(mappedBy = "applicant", fetch = FetchType.EAGER)
    private List<Application> applications = new ArrayList<>();

    @Column(name = "is_deleted")
    @ColumnDefault("'N'")
    private String isDeleted;

}
