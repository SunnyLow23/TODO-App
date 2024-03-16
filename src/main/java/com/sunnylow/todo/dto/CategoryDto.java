package com.sunnylow.todo.dto;

import com.sunnylow.todo.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryDto {

	private Long id;
	private String name;
	private String description;
	private Long userId;
	private List<TodoDto> todoDtos;

	public static Category mapToEntity(CategoryDto categoryDto) {
		final Category category = new Category();

		category.setId(categoryDto.getId());
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());

		return category;
	}

	public static CategoryDto mapToDto(Category category) {
		return CategoryDto.builder()
				.id(category.getId())
				.name(category.getName())
				.description(category.getDescription())
				.userId(category.getUser().getId())
				.todoDtos(
						category.getTodos() != null ? category.getTodos()
								.stream().map(TodoDto::mapToDto).collect(Collectors.toList()) : null
				)
				.build();
	}
}
