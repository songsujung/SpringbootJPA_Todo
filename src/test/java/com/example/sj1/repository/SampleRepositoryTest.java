package com.example.sj1.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class SampleRepositoryTest {
	
    // 의존성 주입
    @Autowired
    private SampleRepository sampleRepository;
    
    // 설정 확인
    @Test
    public void test1(){
        log.info(sampleRepository.getClass().getName());

        log.info("------------------------------");
    }

}