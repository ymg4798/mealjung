package com.mealjung.sample.entity;

import com.mealjung.sample.controller.dto.SampleSearchCondition;
import com.mealjung.sample.controller.dto.SamplesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SampleRepositoryCustom {
    Page<SamplesResponse> search(SampleSearchCondition condition, Pageable pageable);
}


