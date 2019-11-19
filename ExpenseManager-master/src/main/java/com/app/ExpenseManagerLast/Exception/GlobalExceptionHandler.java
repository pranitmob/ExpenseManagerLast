package com.app.ExpenseManagerLast.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
		
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
		ResponseMsg msg = new ResponseMsg(ex.getMessage());
		return new ResponseEntity<Object>(msg,HttpStatus.NOT_FOUND);
	}
	

}
