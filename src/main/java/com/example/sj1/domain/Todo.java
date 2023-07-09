package com.example.sj1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tbl_todo")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
public class Todo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoIncrement : 값이 자동으로 1씩 증가
    private Long tno;

    @Column(length = 300, nullable = false) // 300자 제한, not null
    private String title;
    
}
