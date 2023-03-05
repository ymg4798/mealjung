package com.mealjung.sample.service;

import com.mealjung.common.page.PageRequest;
import com.mealjung.common.page.PageResponse;
import com.mealjung.sample.controller.dto.*;
import com.mealjung.sample.entity.Sample;
import com.mealjung.sample.entity.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.mealjung.sample.entity.Sample.create;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    @Transactional
    public Long save(SampleSaveRequest request) {
        return sampleRepository.save(create(request)).getId();
    }

    @Transactional
    public Long update(Long id, SampleUpdateRequest request) {
        Sample sample = sampleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id = " + id));
        sample.update(request);
        return sample.getId();
    }

    @Transactional
    public Long delete(Long id) {
        Sample sample = sampleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id = " + id));
        sampleRepository.delete(sample);
        return sample.getId();
    }

    public PageResponse<SamplesResponse> findByCondition(SampleSearchCondition condition) {
        return new PageResponse<>(sampleRepository.search(condition, new PageRequest(condition.getPage()).of()));
    }

    public SampleResponse findById(Long id) {
        return new SampleResponse(sampleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id = " + id)));
    }

}


