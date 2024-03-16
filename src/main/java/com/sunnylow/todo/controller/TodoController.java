package com.sunnylow.todo.controller;

import com.sunnylow.todo.controller.api.TodoApi;
import com.sunnylow.todo.dto.TodoDto;
import com.sunnylow.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController implements TodoApi {

	@Autowired
	private TodoService todoService;

	@Override
	public ResponseEntity<TodoDto> createTodo(Long categoryId, TodoDto todoDto) {
		return new ResponseEntity<>(todoService.save(categoryId, todoDto), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<TodoDto> updateTodo(Long id, TodoDto todoDto) {
		return new ResponseEntity<>(todoService.update(id, todoDto), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<TodoDto>> getAllTodos() {
		return new ResponseEntity<>(todoService.getAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<TodoDto> getTodo(Long id) {
		return new ResponseEntity<>(todoService.getById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<TodoDto>> getAllByCategoryId(Long categoryId) {
		return new ResponseEntity<>(todoService.getAllByCategoryId(categoryId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteTodo(Long id) {
		todoService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
