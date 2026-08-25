package com.example.improto;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2083712351877025867L;

	//call up to RuntimeException with current error
	public NotFoundException(String msg) {
		super(msg);
	}
}
