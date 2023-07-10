package com.example.sj1.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    // @RequestBody : 받은 JSON 데이터를 객체로 변환(임포트 주의)
    @PostMapping("/")  
    public TodoDTO register(@RequestBody TodoDTO todoDTO){

        log.info("register................");
        log.info(todoDTO);

        return todoService.register(todoDTO);
    }

    // 조회
    // @Pathvariable : 스프링 MVC에서 동적 URL 경로 변수를 추출({tno}가 고정된 값이 아니기 때문에 사용)
    @GetMapping("/{tno}")
    public TodoDTO get(@PathVariable Long tno){

        return todoService.getOne(tno);
    }

    //삭제
    @DeleteMapping("/{tno}")
    public Map<String, String> delete(@PathVariable("tno") Long tno){

        todoService.remove(tno);

        return Map.of("result", "success");
    }
    
    
    
}
