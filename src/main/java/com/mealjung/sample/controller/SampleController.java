package com.mealjung.sample.controller;

import com.mealjung.common.page.PageResponse;
import com.mealjung.sample.controller.dto.*;
import com.mealjung.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class SampleController {

    private final SampleService sampleService;

    @PostMapping("/sample")
    public Long save(@RequestBody SampleSaveRequest request) {
        return sampleService.save(request);
    }

    @PutMapping("/sample/{id}")
    public Long update(@PathVariable("id") Long id,@RequestBody SampleUpdateRequest request) {
        return sampleService.update(id, request);
    }

    @DeleteMapping("/sample/{id}")
    public Long delete(@PathVariable("id") Long id) {
        return sampleService.delete(id);
    }

    @GetMapping("/samples")
    public PageResponse<SamplesResponse> samples(SampleSearchCondition condition) {
        return sampleService.findByCondition(condition);
    }

    @GetMapping("/sample/{id}")
    public SampleResponse sample(@PathVariable("id") Long id) {
        return sampleService.findById(id);
    }
}


