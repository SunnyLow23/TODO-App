package com.sunnylow.todo.controller.api;

import com.sunnylow.todo.dto.CategoryDto;
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

@Tag(name = "API Category")
public interface CategoryApi {

	@PostMapping(value = APP_ROOT + "/categories/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create category", description = "Create a new category")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "The newly created category"),
			@ApiResponse(responseCode = "2001", description = "Category is not valid"),
			@ApiResponse(responseCode = "1000", description = "No user found")
	})
	ResponseEntity<CategoryDto> createCategory(
			@Parameter(
					name = "User ID",
					description = "ID of user",
					required = true
			) @PathVariable("id") Long userId,
			@Parameter(
					name = "Category DTO",
					description = "Information of new category",
					required = true
			) @RequestBody CategoryDto categoryDto);

	@PatchMapping(value = APP_ROOT + "/categories/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update category", description = "Update an existing category")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Updated a category successfully"),
			@ApiResponse(responseCode = "2001", description = "Category is not valid"),
			@ApiResponse(responseCode = "1001", description = "No category found")
	})
	ResponseEntity<CategoryDto> updateCategory(
			@Parameter(
					name = "Category ID",
					description = "ID of category",
					required = true
			) @PathVariable("id") Long id,
			@Parameter(
					name = "Category DTO",
					description = "New information of category",
					required = true
			)
			@RequestBody CategoryDto categoryDto);

	@GetMapping(value = APP_ROOT + "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get all categories", description = "Returns the list of the categories")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "List of the categories")
	})
	ResponseEntity<List<CategoryDto>> getAllCategories();

	@GetMapping(value = APP_ROOT + "/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the category", description = "Returns the category by that category's ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "The category need find"),
			@ApiResponse(responseCode = "1001", description = "No category found")
	})
	ResponseEntity<CategoryDto> getCategory(
			@Parameter(
					name = "Category ID",
					description = "ID of category",
					required = true
			) @PathVariable("id") Long id);

	@GetMapping(value = APP_ROOT + "/categories/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get all categories by user's ID", description = "Returns the list of the categories by user's ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "List of the categories")
	})
	ResponseEntity<List<CategoryDto>> getAllByUserId(
			@Parameter(
					name = "User ID",
					description = "ID of user",
					required = true
			) @PathVariable("id") Long userId);

	@DeleteMapping(value = APP_ROOT + "/categories/{id}")
	@Operation(summary = "Delete a category", description = "Delete a category by ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Deleted category successfully")
	})
	ResponseEntity deleteCategory(
			@Parameter(
					name = "Category ID",
					description = "ID of category",
					required = true
			) @PathVariable("id") Long id);
}
