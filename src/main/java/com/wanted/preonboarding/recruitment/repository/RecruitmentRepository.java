package com.wanted.preonboarding.recruitment.repository;

import com.wanted.preonboarding.recruitment.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {

    Recruitment findByCompany_Name(String name);

    List<Recruitment> findAllByCompany_Name(String companyName);
    List<Recruitment> findAllByOrderByRegDateDesc();

}
