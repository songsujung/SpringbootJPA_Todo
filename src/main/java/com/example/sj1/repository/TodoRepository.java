package com.example.sj1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sj1.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
