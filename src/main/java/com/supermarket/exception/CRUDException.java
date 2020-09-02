package com.supermarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;





@ControllerAdvice
@RestController
public class CRUDException {

	@ExceptionHandler(value = EmptyDb.class)
	public ResponseEntity<Object> emptyDatabaseException(EmptyDb exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
	@ExceptionHandler(value = NoUser.class)
	public ResponseEntity<Object> noUserException(NoUser exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
}
