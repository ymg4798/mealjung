package com.mealjung.service;

import com.mealjung.entity.Sample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SampleServiceTest {

    @Autowired
    SampleService sampleService;

    @Test
    public void save() {
        Sample request = Sample.builder()
                .name("양민규")
                .address("주소오오오")
                .openYn("Y")
                .build();
        Long id = sampleService.save(request);
        assertThat(id).isEqualTo(1L);
    }
}