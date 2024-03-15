package com.sunnylow.todo.controller.api;


import com.sunnylow.todo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sunnylow.todo.utils.Constant.APP_ROOT;

public interface UserApi {

	@PostMapping(value = APP_ROOT + "/users")
	ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto);

	@PatchMapping(value = APP_ROOT + "/users/{id}")
	ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto);

	@GetMapping(value = APP_ROOT + "/users")
	ResponseEntity<List<UserDto>> getAllUsers();

	@GetMapping(value = APP_ROOT + "/users/{id}")
	ResponseEntity<UserDto> getUser(@PathVariable("id") Long id);

	@DeleteMapping(value = APP_ROOT + "/users/{id}")
	ResponseEntity deleteUser(@PathVariable("id") Long id);
}
