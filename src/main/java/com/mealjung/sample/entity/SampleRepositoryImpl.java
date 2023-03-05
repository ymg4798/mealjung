package com.mealjung.sample.entity;

import com.mealjung.config.querydsl.QuerydslRepositorySupport;
import com.mealjung.sample.controller.dto.QSamplesResponse;
import com.mealjung.sample.controller.dto.SampleSearchCondition;
import com.mealjung.sample.controller.dto.SamplesResponse;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static com.mealjung.sample.entity.QSample.sample;
import static org.springframework.util.StringUtils.hasText;

@Repository
public class SampleRepositoryImpl extends QuerydslRepositorySupport implements SampleRepositoryCustom {

    public SampleRepositoryImpl() {
        super(Sample.class);
    }


    @Override
    public Page<SamplesResponse> search(SampleSearchCondition condition, Pageable pageable) {
        return applyPagination(pageable,
                contentQuery -> contentQuery
                        .select(new QSamplesResponse(sample))
                        .from(sample)
                        .where(
                                nameContains(condition.getName()),
                                openYnEq(condition.getOpenYn())
                        ),
                countQuery -> countQuery
                        .select(sample.count())
                        .from(sample)
                        .where(
                                nameContains(condition.getName()),
                                openYnEq(condition.getOpenYn())
                        ));
    }

    private BooleanExpression nameContains(String name) {
        return hasText(name) ? sample.name.contains(name) : null;
    }

    private BooleanExpression openYnEq(String openYn) {
        return hasText(openYn) ? sample.name.eq(openYn) : null;
    }
}


