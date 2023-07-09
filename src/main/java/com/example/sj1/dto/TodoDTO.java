package com.example.sj1.dto;

import lombok.Data;

// dto는 getter,setter가 자유롭기 때문에 @data 사용
@Data // Getter, Setter, equals(), hashCode(), toString() 등의 메서드를 자동으로 생성
public class TodoDTO {

    private Long tno;
    private String title;
    
}
