package com.wanted.preonboarding.recruitment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.config.TestDataInit;
import com.wanted.preonboarding.recruitment.dto.RecruitmentRegisterDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentUpdateDto;
import com.wanted.preonboarding.recruitment.entity.Company;
import com.wanted.preonboarding.recruitment.entity.Recruitment;
import com.wanted.preonboarding.recruitment.repository.CompanyRepository;
import com.wanted.preonboarding.recruitment.repository.RecruitmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("채용공고 Controller 테스트")
@AutoConfigureMockMvc
@SpringBootTest
class RecruitmentControllerTest {

    @Autowired
    ObjectMapper mapper;
    @Autowired
    MockMvc mvc;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    RecruitmentRepository recruitmentRepository;
    @Autowired
    private TestDataInit testDataInit;

    private static final String BASE_URL = "/recruitment";

    @BeforeEach
    void getTestCompany() {
        testDataInit.createDummyDataForRecruitmentTest();
    }

    @Test
    @DisplayName("채용공고 저장 요청 테스트")
    void postRecruitmentTest() throws Exception {

        //given
        Company company = companyRepository.findAll().get(0);
        String body = mapper.writeValueAsString(RecruitmentRegisterDto.builder()
                .companyId(company.getId())
                .position("백엔드 주니어 개발자")
                .signingBonus(0)
                .techStack("Spring")
                .content("많은 지원 바랍니다.")
                .build());

        //then
        mvc.perform(post(BASE_URL)
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }


    @Test
    @DisplayName("채용공고 수정 요청 테스트")
    void putRecruitmentTest() throws Exception {
        //given
        Recruitment recruitment = recruitmentRepository.findAll().get(0);
        String body = mapper.writeValueAsString(RecruitmentUpdateDto.builder()
                .position("백엔드 시니어 개발자")
                .signingBonus(1_000_000)
                .techStack("Spring")
                .content("업계 최고 대우 예정입니다.")
                .build());

        //then
        mvc.perform(put(BASE_URL + "/" + recruitment.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("채용공고 삭제 요청 테스트")
    void deleteRecruitmentTest() throws Exception {

        //given
        Recruitment recruitment = recruitmentRepository.findAll().get(0);

        //then
        mvc.perform(delete(BASE_URL + "/" + recruitment.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}