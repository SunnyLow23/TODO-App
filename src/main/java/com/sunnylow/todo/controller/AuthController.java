package com.sunnylow.todo.controller;

import com.sunnylow.todo.controller.api.AuthApi;
import com.sunnylow.todo.dto.UserDto;
import com.sunnylow.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {

	@Autowired
	private UserService userService;

	@Override
	public ResponseEntity<UserDto> loginUser(UserDto userDto) {
		return new ResponseEntity<>(userService.login(userDto), HttpStatus.OK);
	}
}
