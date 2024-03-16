package com.sunnylow.todo.validator;

import com.sunnylow.todo.dto.TodoDto;

import java.util.ArrayList;
import java.util.List;

public class TodoValidator {

	public static List<String> validateTodo(TodoDto todoDto) {
		List<String> errors = new ArrayList<>();

		if (todoDto == null) {
			errors.add("Please fill the Title");
			errors.add("Please fill the Description");
			errors.add("Please select a Category");
		}

		if (todoDto.getTitle() == null || todoDto.getTitle().isBlank()) {
			errors.add("Please fill the Title");
		}
		if (todoDto.getDescription() == null || todoDto.getDescription().isBlank()) {
			errors.add("Please fill the Description");
		}
		return errors;
	}
}
