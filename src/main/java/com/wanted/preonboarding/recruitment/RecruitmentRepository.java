package com.wanted.preonboarding.recruitment;

import com.wanted.preonboarding.recruitment.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {
}
