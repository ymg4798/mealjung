package com.mealjung.service;

import com.mealjung.entity.Sample;
import com.mealjung.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    @Transactional
    public Long save(Sample sample) {
        return sampleRepository.save(sample).getId();
    }
}


