package com.example.sj1.service;

import java.util.List;
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


    
}
