package com.sunnylow.todo.validator;

import com.sunnylow.todo.dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

	public static List<String> validateCategory(CategoryDto categoryDto) {
		List<String> errors = new ArrayList<>();

		if (categoryDto == null) {
			errors.add("Please fill the Name");
			errors.add("Please fill the Description");

			return errors;
		}

		if (categoryDto.getName().isBlank()) {
			errors.add("Please fill the Name");
		}
		if (categoryDto.getDescription().isBlank()) {
			errors.add("Please fill the Description");
		}

		return errors;
	}
}
