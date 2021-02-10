package com.taomish.JobManagement.Exception;

public class JobNotFoundException extends RuntimeException {

	public JobNotFoundException() {
		super();
	}

	public JobNotFoundException(String message) {
		super(message);
	}
	
}
