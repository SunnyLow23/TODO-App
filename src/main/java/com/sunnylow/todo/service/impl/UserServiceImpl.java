package com.sunnylow.todo.service.impl;

import com.sunnylow.todo.dto.UserDto;
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
			return null;
		}

		return UserDto.mapToDto(userRepository.save(UserDto.mapToEntity(userDto)));
	}

	@Override
	public List<UserDto> findAll() {
		return userRepository.findAll().stream()
				.map(UserDto::mapToDto).collect(Collectors.toList());
	}

	@Override
	public UserDto findById(Long id) {
		if (id == null) {
			log.error("User ID is null");
			return null;
		}

		return userRepository.findById(id).map(UserDto::mapToDto)
				.orElseThrow();
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			log.error("User ID is null");
			return;
		}

		userRepository.deleteById(id);
	}
}
