package com.taomish.JobManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomeGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(JobHistoryNotFoundException.class)
	ResponseEntity<Object> exception(JobHistoryNotFoundException exception) {
		
		 return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BadRequestException.class)
	ResponseEntity<Object> exception(BadRequestException exception) {
		
		 return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(JobNotFoundException.class)
	ResponseEntity<Object> exception(JobNotFoundException exception) {
		
		 return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	ResponseEntity<Object> exception(Exception exception) {
		
		 return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
