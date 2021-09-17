package com.sw.api.starwars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sw.api.starwars.util.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class PlanetNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(PlanetNotFoundException.class)
	public final ResponseEntity<Object> exceptionHandler(PlanetNotFoundException exception) {
		log.error("PlanetNotFoundException - Message: {}", exception);

		Response<Void> response = new Response<>();
		response.addError(exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
