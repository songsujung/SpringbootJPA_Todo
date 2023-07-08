package com.example.sj1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sj1.domain.Sample;

// extends JpaRepository<도메인명(@Entity), PK데이터타입(@Id)>
public interface SampleRepository extends JpaRepository<Sample, String> {
    
}
