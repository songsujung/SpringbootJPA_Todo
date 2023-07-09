package com.example.sj1.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sj1.dto.PageResponseDTO;
import com.example.sj1.dto.TodoDTO;
import com.example.sj1.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController // HTTP 요청을 처리하고 JSON 또는 XML과 같은 형식으로 응답을 반환
@RequestMapping("/api/todos/")
@RequiredArgsConstructor // TodoService를 주입받을 수 있음
@CrossOrigin
public class TodoController {

    private final TodoService todoService;

    // 목록
    @GetMapping("list")
    public PageResponseDTO<TodoDTO> list(){

        return todoService.getList();
    }

    // 등록
    @PostMapping("/")  

    // 받은 JSON 데이터를 객체로 변환
    public TodoDTO register(@RequestBody TodoDTO todoDTO){

        log.info("register................");
        log.info(todoDTO);

        return todoService.register(todoDTO);

    }
    
}
