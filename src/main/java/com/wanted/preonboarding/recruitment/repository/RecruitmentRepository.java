package com.wanted.preonboarding.recruitment.repository;

import com.wanted.preonboarding.recruitment.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {
}
