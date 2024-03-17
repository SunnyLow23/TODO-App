package com.sunnylow.todo.controller.api;

import com.sunnylow.todo.dto.TodoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sunnylow.todo.utils.Constant.APP_ROOT;

@Tag(name = "API Todo")
public interface TodoApi {

	@PostMapping(value = APP_ROOT + "/todos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create todo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "The newly created todo"),
			@ApiResponse(responseCode = "2002", description = "Todo is not valid"),
			@ApiResponse(responseCode = "1001", description = "No category found")
	})
	ResponseEntity<TodoDto> createTodo(
			@Parameter(
					name = "Category ID",
					required = true
			) @PathVariable("id") Long categoryId,
			@Parameter(
					name = "Todo DTO",
					required = true
			) @RequestBody TodoDto todoDto);

	@PatchMapping(value = APP_ROOT + "/todos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update todo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Updated todo successfully"),
			@ApiResponse(responseCode = "2002", description = "Todo is not valid"),
			@ApiResponse(responseCode = "1002", description = "No todo found")
	})
	ResponseEntity<TodoDto> updateTodo(
			@Parameter(
					name = "Todo ID",
					required = true
			) @PathVariable("id") Long id,
			@Parameter(
					name = "Todo DTO",
					required = true
			) @RequestBody TodoDto todoDto);

	@GetMapping(value = APP_ROOT + "/todos", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get all todos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "List of the todos")
	})
	ResponseEntity<List<TodoDto>> getAllTodos();

	@GetMapping(value = APP_ROOT + "/todos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the todo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "The todo need find"),
			@ApiResponse(responseCode = "1002", description = "No todo found")
	})
	ResponseEntity<TodoDto> getTodo(
			@Parameter(
					name = "Todo ID",
					required = true
			) @PathVariable("id") Long id);

	@GetMapping(value = APP_ROOT + "/todos/categories/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get all todos by category's ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "List of the todos")
	})
	ResponseEntity<List<TodoDto>> getAllByCategoryId(
			@Parameter(
					name = "Category ID",
					required = true
			) @PathVariable("id") Long categoryId);

	@DeleteMapping(value = APP_ROOT + "/todos/{id}")
	@Operation(summary = "Delete a todo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Deleted todo successfully")
	})
	ResponseEntity deleteTodo(
			@Parameter(
					name = "Todo ID",
					required = true
			) @PathVariable("id") Long id);
}
