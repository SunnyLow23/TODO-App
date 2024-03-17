package com.sunnylow.todo.service.impl;

import com.sunnylow.todo.dto.TodoDto;
import com.sunnylow.todo.exception.EntityNotFoundException;
import com.sunnylow.todo.exception.ErrorCodes;
import com.sunnylow.todo.exception.InvalidEntityException;
import com.sunnylow.todo.model.Category;
import com.sunnylow.todo.model.Todo;
import com.sunnylow.todo.repository.CategoryRepository;
import com.sunnylow.todo.repository.TodoRepository;
import com.sunnylow.todo.service.TodoService;
import com.sunnylow.todo.validator.TodoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public TodoDto save(Long categoryId, TodoDto todoDto) {
		List<String> errors = TodoValidator.validateTodo(todoDto);
		if (!errors.isEmpty()) {
			log.error("Todo is not valid {}", todoDto);
			throw new InvalidEntityException("Todo is not valid", ErrorCodes.TODO_NOT_VALID, errors);
		}

		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new EntityNotFoundException("No Category found with ID = " + categoryId, ErrorCodes.CATEGORY_NOT_FOUND));

		Todo todo = TodoDto.mapToEntity(todoDto);
		todo.setCategory(category);

		return TodoDto.mapToDto(todoRepository.save(todo));
	}

	@Override
	public TodoDto update(Long id, TodoDto todoDto) {
		List<String> errors = TodoValidator.validateTodo(todoDto);
		if (!errors.isEmpty()) {
			log.error("Todo is not valid {}", todoDto);
			throw new InvalidEntityException("Todo is not valid", ErrorCodes.TODO_NOT_VALID, errors);
		}

		Todo todo = todoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No Todo found with ID = " + id, ErrorCodes.TODO_NOT_FOUND));

		todo.setTitle(todoDto.getTitle());
		todo.setDescription(todoDto.getDescription());

		return TodoDto.mapToDto(todoRepository.save(todo));
	}

	@Override
	public List<TodoDto> getAll() {
		return todoRepository.findAll().stream()
				.map(TodoDto::mapToDto).collect(Collectors.toList());
	}

	@Override
	public TodoDto getById(Long id) {
		if (id == null) {
			log.error("Todo ID is null");
			return null;
		}

		return todoRepository.findById(id).map(TodoDto::mapToDto)
				.orElseThrow(() -> new EntityNotFoundException("No Todo found with ID = " + id, ErrorCodes.TODO_NOT_FOUND));
	}

	@Override
	public List<TodoDto> getAllByCategoryId(Long categoryId) {
		return todoRepository.findTodoByCategoryId(categoryId).stream()
				.map(TodoDto::mapToDto).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			log.error("Todo ID is null");
			return;
		}

		todoRepository.deleteById(id);
	}
}
