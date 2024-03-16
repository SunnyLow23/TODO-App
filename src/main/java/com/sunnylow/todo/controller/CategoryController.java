package com.sunnylow.todo.controller;

import com.sunnylow.todo.controller.api.CategoryApi;
import com.sunnylow.todo.dto.CategoryDto;
import com.sunnylow.todo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

	@Autowired
	private CategoryService categoryService;

	@Override
	public ResponseEntity<CategoryDto> createCategory(Long userId, CategoryDto categoryDto) {
		return new ResponseEntity<>(categoryService.save(userId, categoryDto), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<CategoryDto> updateCategory(Long id, CategoryDto categoryDto) {
		return new ResponseEntity<>(categoryService.update(id, categoryDto), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CategoryDto> getCategory(Long id) {
		return new ResponseEntity<>(categoryService.getById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<CategoryDto>> getAllByUserId(Long userId) {
		return new ResponseEntity<>(categoryService.getAllByUserId(userId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteCategory(Long id) {
		categoryService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
