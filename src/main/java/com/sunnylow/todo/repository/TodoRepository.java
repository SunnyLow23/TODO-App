package com.sunnylow.todo.repository;

import com.sunnylow.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	List<Todo> findTodoByCategoryId(Long categoryId);
}
