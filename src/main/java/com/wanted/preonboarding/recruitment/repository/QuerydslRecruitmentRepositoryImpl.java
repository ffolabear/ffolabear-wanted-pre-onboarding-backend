package com.wanted.preonboarding.recruitment.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wanted.preonboarding.common.Tech;
import com.wanted.preonboarding.recruitment.dto.RecruitmentSearchRequestDto;
import com.wanted.preonboarding.recruitment.entity.Recruitment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.wanted.preonboarding.recruitment.entity.QRecruitment.recruitment;

@RequiredArgsConstructor
@Repository
public class QuerydslRecruitmentRepositoryImpl implements QuerydslRecruitmentRepositoryCustom {

    private final JPAQueryFactory query;

    @Override
    public List<Recruitment> findRecruitmentByCondition(RecruitmentSearchRequestDto recruitmentSearchRequestDto) {
        return query.select(recruitment)
                .from(recruitment)
                .where(
                        eqPosition(recruitmentSearchRequestDto.getPosition()),
                        eqCompany(recruitmentSearchRequestDto.getCompanyName()),
                        goeSigningBonus(recruitmentSearchRequestDto.getSigningBonus()),
                        eqTechStack(recruitmentSearchRequestDto.getTechStack()))
                .fetch();
    }

    private BooleanExpression eqPosition(String position) {
        if (StringUtils.hasText(position)) {
            return recruitment.position.containsIgnoreCase(position);
        }
        return null;
    }

    private BooleanExpression goeSigningBonus(Integer signingBonus) {
        if (signingBonus == null || signingBonus < 0) {
            return null;
        }
        return recruitment.signingBonus.goe(signingBonus);
    }

    private BooleanExpression eqCompany(String companyName) {
        if (StringUtils.hasText(companyName)) {
            return recruitment.company.name.containsIgnoreCase(companyName);
        }
        return null;
    }

    private BooleanExpression eqTechStack(String techStack) {
        if (StringUtils.hasText(techStack)) {
            return recruitment.techStack.eq(Tech.isTechExist(techStack));
        }
        return null;
    }

}
