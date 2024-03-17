package com.sunnylow.todo.handlers;

import com.sunnylow.todo.exception.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorDto {

	private Integer httpCode;
	private ErrorCodes codes;
	private String message;
	List<String> errors = new ArrayList<>();
}
