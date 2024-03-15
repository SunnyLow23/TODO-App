package com.sunnylow.todo.service;

import com.sunnylow.todo.dto.UserDto;

import java.util.List;

public interface UserService {

	UserDto save(UserDto userDto);

	UserDto update(Long id, UserDto userDto);

	List<UserDto> getAll();

	UserDto getById(Long id);

	void delete(Long id);
}
