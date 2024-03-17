package com.sunnylow.todo.controller.api;

import com.sunnylow.todo.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.sunnylow.todo.utils.Constant.APP_ROOT;

@Tag(name = "API Authentication")
public interface AuthApi {

	@PostMapping(value = APP_ROOT + "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Login account")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Login successfully"),
			@ApiResponse(responseCode = "2000", description = "User is not valid"),
			@ApiResponse(responseCode = "1000", description = "No user found with email and/or password")
	})
	ResponseEntity<UserDto> loginUser(
			@Parameter(
					name = "User DTO",
					example = "aba",
					required = true
			) @RequestBody UserDto userDto);
}
