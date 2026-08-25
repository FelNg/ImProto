package com.example.improto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(InvalidInputException.class)
	//supplied ID in the path is null
	public static ResponseEntity<Object> handleNullInputIdException() {
		//therefore, throw an error under code 400
		return ResponseEntity
				.status(HttpStatus.NOT_ACCEPTABLE)
				.body(	"Error code: 400 - Bad Request.\n" + 
						"The ID supplied in the path is null.");
	}
	
	@ExceptionHandler(NotFoundException.class)
	//no entry can be found with the supplied ID, 
	public static ResponseEntity<Object> handleEntryByIdNotFoundException() {
		//therefore, throw an error under code 404
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(	"Error code: 404 - Not Found.\n" + 
						"Person cannot be found with specified ID.");
	}
}
