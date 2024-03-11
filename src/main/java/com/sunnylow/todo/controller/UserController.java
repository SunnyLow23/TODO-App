package com.sunnylow.todo.controller;

import com.sunnylow.todo.controller.api.UserApi;
import com.sunnylow.todo.dto.UserDto;
import com.sunnylow.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

	@Autowired
	private UserService userService;

	@Override
	public ResponseEntity<UserDto> createUser(UserDto userDto) {
		return new ResponseEntity<>(userService.save(userDto), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<UserDto> updateUser(Long id, UserDto userDto) {
		return new ResponseEntity<>(userService.save(userDto), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserDto> getUser(Long id) {
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteUser(Long id) {
		userService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
