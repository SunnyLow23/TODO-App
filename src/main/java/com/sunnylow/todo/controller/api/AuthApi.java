package com.sunnylow.todo.controller.api;

import com.sunnylow.todo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.sunnylow.todo.utils.Constant.APP_ROOT;

public interface AuthApi {

	@PostMapping(value = APP_ROOT + "/auth/login")
	ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto);
}
