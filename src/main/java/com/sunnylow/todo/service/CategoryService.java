package com.sunnylow.todo.service;

import com.sunnylow.todo.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

	CategoryDto save(Long userId, CategoryDto categoryDto);

	CategoryDto update(Long id, CategoryDto categoryDto);

	List<CategoryDto> getAll();

	CategoryDto getById(Long id);

	List<CategoryDto> getAllByUserId(Long userId);

	void delete(Long id);

//	List<CategoryDto> getAllTodoByCategoriesForToday(Long userId);
}
