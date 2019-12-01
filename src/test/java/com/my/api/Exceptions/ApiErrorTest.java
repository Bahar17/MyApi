package com.my.api.Exceptions;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import com.my.api.service.ApplicationConstants;

/**
 * 
 * The Class ApiErrorTest.
 *
 */
public class ApiErrorTest {
	/**
     * Class under test.
     */
    private ApiError apiError;
    
    private List<String> errors;
    

    /**
     * Method executed before each test method.
     */
    @Before
    public void setUp ()
    {
    	apiError = new ApiError(HttpStatus.NOT_FOUND, ApplicationConstants.MESSAGE,
    			ApplicationConstants.ERROR);
    	apiError.setStatus(HttpStatus.NOT_FOUND);
    	apiError.setMessage(ApplicationConstants.MESSAGE);

    	errors = new ArrayList<>();
    	errors.add(ApplicationConstants.ERROR);
		apiError.setErrors(errors );
    }
    
    /**
     * Test teardown method.
     */
    @After
    public void teardown ()
    {
    	apiError = null;
    	errors = null;
    }
    
    
    /**
     * test get methods.
     */
    @Test
    public void testGetMethods ()
    {
    	assertNotNull (apiError.getErrors());
    	assertNotNull (apiError.getMessage());
    	assertNotNull (apiError.getStatus());
    }
}
