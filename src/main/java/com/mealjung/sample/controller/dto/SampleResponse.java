package com.mealjung.sample.controller.dto;

import com.mealjung.sample.entity.Sample;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SampleResponse {
    private String name;
    private String address;

    public SampleResponse(Sample entity) {
        this.name = entity.getName();
        this.address = entity.getAddress();
    }
}
