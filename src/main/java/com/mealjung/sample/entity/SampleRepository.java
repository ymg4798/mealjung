package com.mealjung.sample.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SampleRepository extends JpaRepository<Sample, Long> , SampleRepositoryCustom{
}


