package com.example.sj1.service;

import com.example.sj1.dto.PageResponseDTO;
import com.example.sj1.dto.TodoDTO;

import jakarta.transaction.Transactional;

@Transactional // 트랜잭션 시작, 데이터베이스 작업 수행, 커밋 및 롤백, 트랙잭션 종료와 같은 동작
public interface TodoService {

    // 목록
    PageResponseDTO<TodoDTO> getList();

    // 등록
    TodoDTO register(TodoDTO dto);
 
}
