package com.example.sj1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_sample1")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sample {

    // Entity와 ID는 세트
    // 변수(컬럼명) DB위약어에 위반되지 않는 이름으로 설정하기
    @Id
    private String keyCol;

    private String first;

    private String last;
    
}
