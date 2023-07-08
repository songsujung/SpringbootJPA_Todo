package com.example.sj1.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.sj1.domain.Sample;

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
    }

    // 등록 테스트
    @Test
    public void testInsert(){

        // 100개의 데이터 생성하는 객체
        // rangeClosed : 시작값과 종료값을 포함하는 범위를 생성하는 메서드
        // forEach : 객체의 각 요소에 대해 람다식을 실행하는 메서드 (i는 현재 반복 중인 숫자)
        // => 1부터 100까지의 숫자 범위를 반복하면서 각 숫자에 대해 람다식을 실행하는 코드
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Sample obj = Sample.builder()
            .keyCol("u" + i)
            .first("first")
            .last("last")
            .build();

            // 만든 obj를 저장
            sampleRepository.save(obj);
        });

    }

    // 조회 테스트
    @Test
    public void testRead(){

        String keycol = "u10";

        // 제네릭타입 <> : 코드의 재사용성과 타입 안정성을 높히는 강력한 기능
        // Optional : 값이 존재하지 않는 경우에 지정한 예외을 발생해서 안전하게 처리
        // findById() : 주어진 식별자(값)로 해당하는 데이터를 조회해서 'Optional<Sample>' 형태로 반환
        // => sampleRepository에서 주어진 keycol 값을 사용하여 데이터를 조회하고, 조회 결과를 Optional<Sample> 형태로 반환하여 result 변수에 저장
        Optional<Sample> result = sampleRepository.findById(keycol);

        // orElseThrow() : 값이 없을 경우 ()안의 예외를 반환
        Sample obj = result.orElseThrow(); 

        log.info(obj);

    }

    // 삭제 테스트
    @Test
    public void testDelete(){

        String keycol = "u1";

        // deletebyid: 주어진 값으로 해당하는 조회해서 삭제하는 메서드
        sampleRepository.deleteById(keycol); 

    }

    // 페이징 테스트
    @Test
    public void testPaging(){
        
        // Pageable import할 때 domain으로 할것 !!
        // 첫 번째 페이지(0번째)를 요청하고, 페이지 당 10개의 결과를 반환하도록 페이징 처리를 설정하며, keyCol를 내림차순으로 정렬
        Pageable pageable = PageRequest.of(0, 10, Sort.by("keyCol").descending());

        // findAll : 지정된 페이징 및 정렬 설정에 따라 데이터를 조회
        // pageable를 보내면 반환 타입이 반드시 Page여야 함(공식)
        Page<Sample> result = sampleRepository.findAll(pageable);

        // 데이터의 총 갯수
        log.info(result.getTotalElements()); // 99
        log.info("------------------");

        // 총 몇페이지
        log.info(result.getTotalPages()); // 10
        log.info("------------------");

        // 변수에 저장된 페이지의 내용을 확인
        result.getContent().forEach(obj ->
        log.info(obj)); // 


    }


}