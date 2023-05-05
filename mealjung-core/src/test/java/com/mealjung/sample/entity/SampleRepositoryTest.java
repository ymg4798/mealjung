package com.mealjung.sample.entity;

import com.mealjung.sample.entity.Sample;
import com.mealjung.sample.entity.SampleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SampleRepositoryTest {

    @Autowired
    SampleRepository sampleRepository;

    @AfterEach
    public void clear(){
        sampleRepository.deleteAll();
    }

    @Test
    public void save() {
        Sample request = Sample.builder()
                .name("양민규")
                .address("주소오오오")
                .openYn("Y")
                .build();
        sampleRepository.save(request);

        Sample sample = sampleRepository.findById(1L).get();
        assertThat(sample).isEqualTo(request);
    }
}