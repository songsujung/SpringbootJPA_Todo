package com.example.sj1.dto;

import java.util.List;

// 제네릭타입 <E>(Element의 약어) : 배열(array), 리스트(list), 세트(set), 맵(map)
public class PageResponseDTO<E> {
    
    private List<E> dtoList;
}
