package com.wanted.preonboarding.recruitment;

import com.wanted.preonboarding.common.code.CompanyErrorCode;
import com.wanted.preonboarding.common.exception.CompanyException;
import com.wanted.preonboarding.recruitment.dto.RecruitmentRegisterDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentResponseDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentSearchRequestDto;
import com.wanted.preonboarding.recruitment.dto.RecruitmentUpdateDto;
import com.wanted.preonboarding.recruitment.entity.Company;
import com.wanted.preonboarding.recruitment.entity.Recruitment;
import com.wanted.preonboarding.recruitment.repository.CompanyRepository;
import com.wanted.preonboarding.recruitment.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    public Long addRecruitment(RecruitmentRegisterDto recruitRegisterDto) {
        Company company = companyRepository.findById(recruitRegisterDto.getCompanyId()).orElseThrow(
                () -> new CompanyException(CompanyErrorCode.COMPANY_NOT_FOUND));
        Recruitment recruitment = recruitRegisterDto.toRecruitment(company);
        recruitmentRepository.save(recruitment);
        return recruitment.getId();
    }

    @Transactional
    public Long modifyRecruitment(RecruitmentUpdateDto recruitUpdateDto, Long recruitmentId) {
        Recruitment originalRecruitment = recruitmentRepository.findById(recruitmentId).orElseThrow(
                () -> new CompanyException(CompanyErrorCode.COMPANY_NOT_FOUND));
        originalRecruitment = originalRecruitment.modifyRecruitment(originalRecruitment, recruitUpdateDto);
        return originalRecruitment.getId();
    }

    @Transactional
    public void removeRecruitment(Long recruitmentId) {
        Recruitment recruitment = recruitmentRepository.findById(recruitmentId).orElseThrow(
                () -> new CompanyException(CompanyErrorCode.COMPANY_NOT_FOUND));
        recruitmentRepository.delete(recruitment);
    }

}
