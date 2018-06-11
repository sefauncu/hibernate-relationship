package com.activity.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ActivityRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ActivityErrorResponse> handleException(ActivityNotFoundException exc) {
		
		// create CustomerErrorResponse
		
		ActivityErrorResponse error = new ActivityErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ActivityErrorResponse> handleException(Exception exc) {
		
		// create CustomerErrorResponse
		
		ActivityErrorResponse error = new ActivityErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
