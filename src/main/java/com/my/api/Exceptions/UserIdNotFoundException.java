package com.my.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class UserIdNotFoundException.
 * 
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserIdNotFoundException extends RuntimeException{
	
    /**
     * Serial version id.
     */
	private static final long serialVersionUID = -5060825696669677323L;

    /**
     * UserIdNotFoundException constructor.
     * 
     * @param errorCode string
     * @param errorDescription string
     */

	public UserIdNotFoundException(final String id)
    {
        super ("User id not found : " + id);
    }

}
