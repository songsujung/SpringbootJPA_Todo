package com.example.sj1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 데이터베이스의 테이블과 1:1로 대응됨
@Table(name = "tbl_sample1") // tbl_sample1이라는 이름으로 테이블명 생성
@AllArgsConstructor // 클래스에 선언된 모든 변수에 파라미터가 있는 생성자 생성(null값일 때 에러 막기 위함)
@NoArgsConstructor // 파라미터가 없는 기본 생성자 생성
@Builder // 불변한 객체 생성, Lombok라이브러리 제공(반복적인 코드를 줄여주는 기능)
//@ToString // 객체의 문자열 표현을 반환하는 메서드를 자동으로 생성
@Getter // 클래스의 변수를 외부에서 읽도로 해주는 메서드를 자동으로 생성
public class Sample {

    // Entity와 ID는 세트
    // 변수(컬럼명) DB위약어에 위반되지 않는 이름으로 설정하기
    @Id
    private String keyCol;

    private String first;

    private String last;
    
}
