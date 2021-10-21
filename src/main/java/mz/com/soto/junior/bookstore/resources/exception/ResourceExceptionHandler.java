package mz.com.soto.junior.bookstore.resources.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mz.com.soto.junior.bookstore.service.exceptions.DataIntegrityViolationException;
import mz.com.soto.junior.bookstore.service.exceptions.ObjecteNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjecteNotFoundException.class)
	public ResponseEntity<StanderdError> objecteNotFoundException (ObjecteNotFoundException e, ServletRequest request){
		StanderdError error = new StanderdError(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StanderdError> dataIntegrityViolationException (DataIntegrityViolationException e, ServletRequest request){
		StanderdError error = new StanderdError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
