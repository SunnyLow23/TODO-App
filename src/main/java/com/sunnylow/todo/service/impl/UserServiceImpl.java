package com.sunnylow.todo.service.impl;

import com.sunnylow.todo.dto.UserDto;
import com.sunnylow.todo.exception.EntityNotFoundException;
import com.sunnylow.todo.exception.ErrorCodes;
import com.sunnylow.todo.exception.InvalidEntityException;
import com.sunnylow.todo.model.User;
import com.sunnylow.todo.repository.UserRepository;
import com.sunnylow.todo.service.UserService;
import com.sunnylow.todo.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto save(UserDto userDto) {
		List<String> errors = UserValidator.validateUser(userDto);
		if (!errors.isEmpty()) {
			log.error("User is not valid {}", userDto);
			throw new InvalidEntityException("User is not valid", ErrorCodes.USER_NOT_VALID, errors);
		}

		return UserDto.mapToDto(userRepository.save(UserDto.mapToEntity(userDto)));
	}

	@Override
	public UserDto update(Long id, UserDto userDto) {
		List<String> errors = UserValidator.validateUser(userDto);
		if (!errors.isEmpty()) {
			log.error("User is not valid {}", userDto);
			throw new InvalidEntityException("User is not valid", ErrorCodes.USER_NOT_VALID, errors);
		}

		User user = userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No user found with ID = " + id, ErrorCodes.USER_NOT_FOUND));

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());

		return UserDto.mapToDto(userRepository.save(user));
	}

	@Override
	public List<UserDto> getAll() {
		return userRepository.findAll().stream()
				.map(UserDto::mapToDto).collect(Collectors.toList());
	}

	@Override
	public UserDto getById(Long id) {
		if (id == null) {
			log.error("User ID is null");
			return null;
		}

		return userRepository.findById(id).map(UserDto::mapToDto)
				.orElseThrow(() -> new EntityNotFoundException("No user found with ID = " + id, ErrorCodes.USER_NOT_FOUND));
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			log.error("User ID is null");
			return;
		}

		userRepository.deleteById(id);
	}

	@Override
	public UserDto login(UserDto userDto) {
		List<String> errors = UserValidator.validateUserCredentials(userDto.getEmail(), userDto.getPassword());
		if (!errors.isEmpty()) {
			throw new InvalidEntityException("User is not valid", ErrorCodes.USER_NOT_VALID, errors);
		}

		return userRepository.findUserByEmailAndPassword(userDto.getEmail(), userDto.getPassword())
				.map(UserDto::mapToDto)
				.orElseThrow(() -> new EntityNotFoundException(
						"No user found with Email = " + userDto.getEmail()
						+ " and Password = <HIDDEN_PASSWORD>",
						ErrorCodes.USER_NOT_FOUND
				));
	}
}
