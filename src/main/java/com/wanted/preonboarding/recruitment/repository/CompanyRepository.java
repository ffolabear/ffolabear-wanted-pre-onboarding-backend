package com.wanted.preonboarding.recruitment.repository;

import com.wanted.preonboarding.recruitment.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByName(String name);

}
