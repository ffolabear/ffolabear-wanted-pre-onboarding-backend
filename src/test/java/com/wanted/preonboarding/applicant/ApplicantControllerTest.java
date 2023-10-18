package com.wanted.preonboarding.applicant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.applicant.dto.ApplicantApplyingDto;
import com.wanted.preonboarding.applicant.entity.Applicant;
import com.wanted.preonboarding.applicant.repository.ApplicantRepository;
import com.wanted.preonboarding.config.TestDataInit;
import com.wanted.preonboarding.recruitment.dto.RecruitmentSearchRequestDto;
import com.wanted.preonboarding.recruitment.entity.Recruitment;
import com.wanted.preonboarding.recruitment.repository.RecruitmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("지원자 Controller 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
class ApplicantControllerTest {

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private RecruitmentRepository recruitmentRepository;
    @Autowired
    private TestDataInit testDataInit;

    private static final String BASE_URL = "/applicant";

    @BeforeEach
    void setUp() {
        testDataInit.createDummyDataForApplicantTest();
    }

    @Test
    @DisplayName("모든 채용공고 조회 테스트")
    void getAllRecruitmentTest() throws Exception {
        mvc.perform(get(BASE_URL + "/" + "recruitmentList")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("채용공고 검색 테스트")
    void getSearchedRecruitmentTest() throws Exception {
        //given
        String body = mapper.writeValueAsString(RecruitmentSearchRequestDto.builder().build());

        //then
        mvc.perform(get(BASE_URL + "/" + "search")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("채용공고 상세 내용 테스트")
    void getRecruitmentDetailTest() throws Exception {
        Long recruitmentId = recruitmentRepository.findAll().get(0).getId();
        mvc.perform(get(BASE_URL + "/" + recruitmentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("채용공고 지원 테스트")
    void postApplyingRecruitmentTest() throws Exception {
        //given
        Applicant applyingApplicant = applicantRepository.findAll().get(0);
        Recruitment applyingRecruitment = recruitmentRepository.findAll().get(0);

        //then
        String body = mapper.writeValueAsString(ApplicantApplyingDto.builder()
                .applicantId(applyingApplicant.getId())
                .recruitmentId(applyingRecruitment.getId())
                .build());

        mvc.perform(post(BASE_URL + "/" + applyingRecruitment.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}