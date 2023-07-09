package com.example.sj1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sj1.dto.PageResponseDTO;
import com.example.sj1.dto.TodoDTO;
import com.example.sj1.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController // HTTP 요청을 처리하고 JSON 또는 XML과 같은 형식으로 응답을 반환
@RequestMapping("/api/todos/")
@RequiredArgsConstructor // TodoService를 주입받을 수 있음
public class TodoController {

        private final TodoService todoService;

    @GetMapping("list")
    public PageResponseDTO<TodoDTO> list(){

        return todoService.getList();
    }
    
}
