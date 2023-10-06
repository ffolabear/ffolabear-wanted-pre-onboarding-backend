package com.wanted.preonboarding.applicant.repository;

import com.wanted.preonboarding.applicant.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
