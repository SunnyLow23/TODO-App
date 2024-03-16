package com.sunnylow.todo.controller.api;

import com.sunnylow.todo.dto.TodoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sunnylow.todo.utils.Constant.APP_ROOT;

public interface TodoApi {

	@PostMapping(value = APP_ROOT + "/todos/{id}")
	ResponseEntity<TodoDto> createTodo(@PathVariable("id") Long categoryId, @RequestBody TodoDto todoDto);

	@PatchMapping(value = APP_ROOT + "/todos/{id}")
	ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long id, @RequestBody TodoDto todoDto);

	@GetMapping(value = APP_ROOT + "/todos")
	ResponseEntity<List<TodoDto>> getAllTodos();

	@GetMapping(value = APP_ROOT + "/todos/{id}")
	ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long id);

	@GetMapping(value = APP_ROOT + "/todos/categories/{id}")
	ResponseEntity<List<TodoDto>> getAllByCategoryId(@PathVariable("id") Long categoryId);

	@DeleteMapping(value = APP_ROOT + "/todos/{id}")
	ResponseEntity deleteTodo(@PathVariable("id") Long id);
}
