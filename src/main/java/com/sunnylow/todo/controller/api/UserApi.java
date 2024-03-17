package com.sunnylow.todo.controller.api;


import com.sunnylow.todo.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sunnylow.todo.utils.Constant.APP_ROOT;

@Tag(name = "API User")
public interface UserApi {

	@PostMapping(value = APP_ROOT + "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create user", description = "Create a new user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "The newly created user"),
			@ApiResponse(responseCode = "2000", description = "User is not valid")
	})
	ResponseEntity<UserDto> createUser(
			@Parameter(
					name = "User DTO",
					description = "Information of new user",
					required = true
			) @RequestBody UserDto userDto);

	@PatchMapping(value = APP_ROOT + "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update user", description = "Updates an existing user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Updated a user successfully"),
			@ApiResponse(responseCode = "2000", description = "User is not valid"),
			@ApiResponse(responseCode = "1000", description = "No user found")
	})
	ResponseEntity<UserDto> updateUser(
			@Parameter(
					name = "User ID",
					description = "ID of user",
					required = true
			) @PathVariable("id") Long id,
			@Parameter(
					name = "User DTO",
					description = "New information of user",
					required = true
			) @RequestBody UserDto userDto);

	@GetMapping(value = APP_ROOT + "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get all users", description = "Returns the list of the users")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "List of the users")
	})
	ResponseEntity<List<UserDto>> getAllUsers();

	@GetMapping(value = APP_ROOT + "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the user", description = "Returns the user by that user's ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "The user need find"),
			@ApiResponse(responseCode = "1000", description = "No user found")
	})
	ResponseEntity<UserDto> getUser(
			@Parameter(
					name = "User ID",
					description = "ID of user",
					required = true
			) @PathVariable("id") Long id);

	@DeleteMapping(value = APP_ROOT + "/users/{id}")
	@Operation(summary = "Delete a user", description = "Delete a user by ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Deleted user successfully")
	})
	ResponseEntity deleteUser(
			@Parameter(
					name = "User ID",
					description = "ID of user",
					required = true
			) @PathVariable("id") Long id);
}
