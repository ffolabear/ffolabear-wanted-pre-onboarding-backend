package com.wanted.preonboarding.applicant.repository;

import com.wanted.preonboarding.applicant.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
