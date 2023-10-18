package com.wanted.preonboarding.applicant.entity;

import com.wanted.preonboarding.common.BaseTime;
import com.wanted.preonboarding.recruitment.entity.Recruitment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Application extends BaseTime {

    @Id
    @Column(name = "application_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Applicant applicant;

    @ManyToOne(fetch = FetchType.LAZY)
    private Recruitment recruitment;

    @Column(name = "is_deleted")
    @ColumnDefault("'N'")
    private String isDeleted;

    public void addApplicant() {
        this.applicant.getApplications().add(this);
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", applicant=" + applicant +
                ", recruitment=" + recruitment +
                ", isDeleted='" + isDeleted + '\'' +
                "} + ''\n";
    }
}
