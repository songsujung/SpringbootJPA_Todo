package com.example.sj1.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.sj1.domain.Todo;
import com.example.sj1.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepositoryTest {

    // 의존성 주입
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    // 등록 테스트
    @Test
    public void testInsert(){

        // 게시글 번호는 autoIncrement로 자동으로 값이 생성되기 때문에 값X
        IntStream.rangeClosed(0, 100).forEach(i -> {
            Todo todo = Todo.builder()
            .title("Title" + i)
            .build();

            Todo result = todoRepository.save(todo); // 리턴타입을 todo로 저장

            log.info(result);
        });

    }

    // 조회 테스트
    @Test
    public void testRead(){

        Long tno = 100L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo entity = result.orElseThrow();

        log.info("entity -------------------");
        log.info(entity);

        // modelMapper로 entity를 dto로 변환 작업
        // .map(변환할 객체, 변환할 타입)
        // => entity 객체의 필드 값을 TodoDTO 객체의 필드로 복사하여 변환된 TodoDTO 객체를 반환
        TodoDTO dto = modelMapper.map(entity, TodoDTO.class);

        log.info("DTO ----------------------");
        log.info(dto);
    }

    // 삭제 테스트
    @Test
    public void testDelete(){

        Long tno = 1L;

        todoRepository.deleteById(tno);

    }

    // 페이징 테스트
    // Pageable import할 때 domain으로 하기
    // pageable를 보내면 findAll 반환 타입이 반드시 Page여야 함(공식)
    @Test
    public void testPaging(){

        Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());

        Page<Todo> result = todoRepository.findAll(pageable);

        log.info(result);

    }

}
