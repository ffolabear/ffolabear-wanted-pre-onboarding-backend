package com.wanted.preonboarding.recruitment.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CompanyRepositoryTest {

    @Autowired
    private RecruitmentRepository recruitmentRepository;

    @Test
    void addRecruitmentTest() {

        //given


        //when


        //then

    }

}