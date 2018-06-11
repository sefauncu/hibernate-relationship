package com.activity.rest;

public class ActivityNotFoundException extends RuntimeException {

	public ActivityNotFoundException() {
	
	}

	public ActivityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

	public ActivityNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ActivityNotFoundException(String message) {
		super(message);
		
	}

	public ActivityNotFoundException(Throwable cause) {
		super(cause);
		
	}

	
}
