package com.sunnylow.todo.service.impl;

import com.sunnylow.todo.dto.CategoryDto;
import com.sunnylow.todo.model.Category;
import com.sunnylow.todo.model.User;
import com.sunnylow.todo.repository.CategoryRepository;
import com.sunnylow.todo.repository.UserRepository;
import com.sunnylow.todo.service.CategoryService;
import com.sunnylow.todo.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public CategoryDto save(Long userId, CategoryDto categoryDto) {
		List<String> errors = CategoryValidator.validateCategory(categoryDto);
		if (!errors.isEmpty())  {
			log.error("Category is not valid {}", categoryDto);
			return null;
		}

		User user = userRepository.findById(userId)
				.orElseThrow();

		Category category = CategoryDto.mapToEntity(categoryDto);
		category.setUser(user);

		return CategoryDto.mapToDto(categoryRepository.save(category));
	}

	@Override
	public CategoryDto update(Long id, CategoryDto categoryDto) {
		List<String> errors = CategoryValidator.validateCategory(categoryDto);
		if (!errors.isEmpty())  {
			log.error("Category is not valid {}", categoryDto);
			return null;
		}

		Category category = categoryRepository.findById(id)
				.orElseThrow();

		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());

		return CategoryDto.mapToDto(categoryRepository.save(category));
	}

	@Override
	public List<CategoryDto> getAll() {
		return categoryRepository.findAll().stream()
				.map(CategoryDto::mapToDto).collect(Collectors.toList());
	}

	@Override
	public CategoryDto getById(Long id) {
		if (id == null) {
			log.error("Category ID is null");
			return null;
		}

		return categoryRepository.findById(id).map(CategoryDto::mapToDto)
				.orElseThrow();
	}

	@Override
	public List<CategoryDto> getAllByUserId(Long userId) {
		return categoryRepository.findCategoryByUserId(userId).stream()
				.map(CategoryDto::mapToDto).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			log.error("Category ID is null");
			return;
		}

		categoryRepository.deleteById(id);
	}

//	@Override
//	public List<CategoryDto> getAllTodoByCategoriesForToday(Long userId) {
//		return categoryRepository.findAllTodoByCategoriesForToday(
//				ZonedDateTime.now().withHour(0).withMinute(0),
//						ZonedDateTime.now().withHour(23).withMinute(59),userId)
//				.stream().map(CategoryDto::mapToDto).collect(Collectors.toList());
//	}
}
