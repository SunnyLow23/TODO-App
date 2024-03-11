package com.sunnylow.todo.validator;

import com.sunnylow.todo.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

	public static List<String> validateUser(UserDto userDto) {
		List<String> errors = new ArrayList<>();

		if (userDto == null) {
			errors.add("Please fill the First Name");
			errors.add("Please fill the Last Name");
			errors.add("Please fill the User Email");
			errors.add("Please fill the User Name");
			errors.add("Please fill the Password");

			return errors;
		}

		if (userDto.getFirstName().isEmpty()) {
			errors.add("Please fill the First Name");
		}
		if (userDto.getLastName().isEmpty()) {
			errors.add("Please fill the Last Name");
		}
		if (userDto.getEmail().isEmpty()) {
			errors.add("Please fill the User Email");
		}
		if (userDto.getUserName().isEmpty()) {
			errors.add("Please fill the User Name");
		}
		if (userDto.getPassword().isEmpty()) {
			errors.add("Please fill the Password");
		}

		return errors;
	}
}
