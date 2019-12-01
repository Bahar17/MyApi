package com.my.api.Exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


/**
 * The Class RestExceptionHandler.
 * 
 */
@SuppressWarnings({"unchecked","rawtypes", "serial"})
@ControllerAdvice
public class RestExceptionHandler extends RuntimeException
{
	@ExceptionHandler(UserIdNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(
	    UserIdNotFoundException ex, WebRequest request) {
	    List<String> details = new ArrayList<>();
	    details.add(ex.getLocalizedMessage());
	    
	    ApiError error = new ApiError(HttpStatus.NOT_FOUND,"User Id Not Found", details);
	    
	    return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}
}