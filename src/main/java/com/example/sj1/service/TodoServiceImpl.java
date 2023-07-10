package com.example.sj1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.sj1.domain.Todo;
import com.example.sj1.dto.PageResponseDTO;
import com.example.sj1.dto.TodoDTO;
import com.example.sj1.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final ModelMapper modelMapper;

    private final TodoRepository todoRepository;

    // 목록
    @Override
    public PageResponseDTO<TodoDTO> getList() {
        Pageable pageable = PageRequest.of(0, 20, Sort.by("tno").descending());

        Page<Todo> result = todoRepository.findAll(pageable);

        // .collect(Collectors.toList()) : TodoDTO의 요소들을 리스트로 수집, 스트림요소들을 리스트로 수집
        List<TodoDTO> dtoList = result.getContent().stream()
        .map(todo -> modelMapper.map(todo, TodoDTO.class)).collect(Collectors.toList());
		
        // 구현 안되어서 일단은 주석처리
        // PageResponseDTO<TodoDTO> response = new PageResponseDTO<>();
        // response.setDtoList(dtoList);

        // return response;
        return null;

    }

    // 등록
    @Override
    public TodoDTO register(TodoDTO dto) {
        // dto를 Todo로 변환해서 그 값을 entity에 저장
		// tno를 가지고 있지 않은 Todo
        Todo entity = modelMapper.map(dto, Todo.class); 
				
        // 번호가 들어있는 Todo - autoIncrement를 해줘서 db에 저장될 tno값이 생성됨
        // entity를 db에 저장하고 그 값을 result에 저장
        Todo result = todoRepository.save(entity);
        
        // result 값을 TodoDTO로 변환을 해서 화면에 출력 대기
        return modelMapper.map(result,TodoDTO.class);
    }

    // 조회
    @Override
    public TodoDTO getOne(Long tno) {
        Optional<Todo> result = todoRepository.findById(tno);
        
        Todo todo = result.orElseThrow();

        TodoDTO dto = modelMapper.map(todo, TodoDTO.class);

        return dto;
    }

    // 삭제
    @Override
    public void remove(Long tno) {

        todoRepository.deleteById(tno);
    }


    
}
