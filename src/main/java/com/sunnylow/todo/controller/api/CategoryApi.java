package com.sunnylow.todo.controller.api;

import com.sunnylow.todo.dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sunnylow.todo.utils.Constant.APP_ROOT;

public interface CategoryApi {

	@PostMapping(value = APP_ROOT + "/categories/users/{id}")
	ResponseEntity<CategoryDto> createCategory(@PathVariable("id") Long id, @RequestBody CategoryDto categoryDto);

	@PatchMapping(value = APP_ROOT + "/categories/{id}")
	ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDto categoryDto);

	@GetMapping(value = APP_ROOT + "/categories")
	ResponseEntity<List<CategoryDto>> getAllCategories();

	@GetMapping(value = APP_ROOT + "/categories/{id}")
	ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long id);

	@GetMapping(value = APP_ROOT + "/categories/users/{id}")
	ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(@PathVariable("id") Long userId);

	@DeleteMapping(value = APP_ROOT + "/categories/{id}")
	ResponseEntity deleteCategory(@PathVariable("id") Long id);
}
