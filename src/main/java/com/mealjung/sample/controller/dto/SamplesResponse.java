package com.mealjung.sample.controller.dto;

import com.mealjung.sample.entity.Sample;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class SamplesResponse {
    private String name;
    private String address;
    private LocalDateTime regDate;

    @Builder
    @QueryProjection
    public SamplesResponse(Sample entity) {
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.regDate = entity.getRegDate();
    }
}
