package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExpenseNotFoundException extends RuntimeException{
	private String message;

	public ExpenseNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ExpenseNotFoundException [message=" + message + "]";
	}
	
}
