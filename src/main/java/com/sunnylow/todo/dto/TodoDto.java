package com.sunnylow.todo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sunnylow.todo.model.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TodoDto {

	private Long id;
	private String title;
	private String description;
	private ZonedDateTime startTime;
	private boolean done;
	private boolean favorite;
	private Long categoryId;

	public static Todo mapToEntity(TodoDto todoDto) {
		final Todo todo = new Todo();

		todo.setId(todoDto.getId());
		todo.setTitle(todoDto.getTitle());
		todo.setDescription(todoDto.getDescription());
		todo.setStartTime(todoDto.getStartTime());
		todo.setDone(todoDto.isDone());
		todo.setFavorite(todoDto.isFavorite());

		return todo;
	}

	public static TodoDto mapToDto(Todo todo) {
		return TodoDto.builder()
				.id(todo.getId())
				.title(todo.getTitle())
				.description(todo.getDescription())
				.startTime(todo.getStartTime())
				.done(todo.isDone())
				.favorite(todo.isFavorite())
				.categoryId(todo.getCategory().getId())
				.build();
	}
}
