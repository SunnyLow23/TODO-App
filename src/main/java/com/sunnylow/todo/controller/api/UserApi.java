package com.sunnylow.todo.controller.api;


import com.sunnylow.todo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sunnylow.todo.utils.Constant.APP_ROOT;

public interface UserApi {

	@PostMapping(value = APP_ROOT + "/users/create")
	ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto);

	@PatchMapping(value = APP_ROOT + "/users/{id}")
	ResponseEntity<UserDto> updateUser(Long id, @RequestBody UserDto userDto);

	@GetMapping(value = APP_ROOT + "/users/all")
	ResponseEntity<List<UserDto>> getAllUsers();

	@GetMapping(value = APP_ROOT + "/users/{id}")
	ResponseEntity<UserDto> getUser(Long id);

	@DeleteMapping(value = APP_ROOT + "/users/delete/{id}")
	ResponseEntity deleteUser(Long id);
}
