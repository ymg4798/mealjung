package com.mealjung.sample.entity;

import com.mealjung.common.entity.BaseEntity;
import com.mealjung.sample.controller.dto.SampleSaveRequest;
import com.mealjung.sample.controller.dto.SampleUpdateRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sample")
public class Sample extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sample_id")
    private Long id;

    @Column(columnDefinition = "varchar(10)")
    private String name;

    @Column(columnDefinition = "varchar(50)")
    private String address;

    @Column(columnDefinition = "char(1)")
    private String openYn;

    @Builder
    public Sample(String name, String address, String openYn) {
        this.name = name;
        this.address = address;
        this.openYn = openYn;
    }

    public static Sample create(SampleSaveRequest request) {
        return Sample.builder()
                .name(request.getName())
                .address(request.getAddress())
                .openYn(request.getOpenYn())
                .build();
    }

    public void update(SampleUpdateRequest request) {
        this.address = request.getAddress();
        this.openYn = request.getOpenYn();
    }
}


