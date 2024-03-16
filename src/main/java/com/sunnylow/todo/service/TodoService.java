package com.sunnylow.todo.service;

import com.sunnylow.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {

	TodoDto save(Long categoryId, TodoDto todoDto);

	TodoDto update(Long id, TodoDto todoDto);

	List<TodoDto> getAll();

	TodoDto getById(Long id);

	List<TodoDto> getAllByCategoryId(Long categoryId);

	void delete(Long id);
}
