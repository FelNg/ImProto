package com.example.improto;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidInputException extends RuntimeException {
	private static final long serialVersionUID = 1670458748682160226L;

	//call up to RuntimeException with current error
	public InvalidInputException(String msg) {
		super(msg);
	}
}
