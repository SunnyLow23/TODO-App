package com.sunnylow.todo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sunnylow.todo.model.User;
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
public class UserDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;

	@JsonIgnore
	private List<CategoryDto> categoryDtos;

	public static User mapToEntity(UserDto userDto) {
		final User user = new User();

		user.setId(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		user.setCategories(
				userDto.getCategoryDtos() != null ? userDto.getCategoryDtos()
						.stream().map(CategoryDto::mapToEntity).collect(Collectors.toList()) : null
		);

		return user;
	}

	public static UserDto mapToDto(User user) {
		return UserDto.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.email(user.getEmail())
				.userName(user.getUserName())
				.password(user.getPassword())
				.categoryDtos(
						user.getCategories() != null ? user.getCategories()
								.stream().map(CategoryDto::mapToDto).collect(Collectors.toList()) : null
				)
				.build();
	}
}
