package com.sunnylow.todo.service;

import com.sunnylow.todo.dto.UserDto;

import java.util.List;

public interface UserService {

	UserDto save(UserDto userDto);

	List<UserDto> findAll();

	UserDto findById(Long id);

	void delete(Long id);
}
