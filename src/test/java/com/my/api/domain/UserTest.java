package com.my.api.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.my.api.service.ApplicationConstants;

/**
 * 
 * The Class UserTest.
 *
 */
public class UserTest {
	
	/**
     * Class under test.
     */
    private User user1;
    
	/**
     * Class under test.
     */
    @SuppressWarnings("unused")
	private User user2;
    
    private Address address;


    /**
     * Method executed before each test method.
     */
    @Before
    public void setUp ()
    {
    	address = new Address();
    	user1 = new User (ApplicationConstants.ID1, ApplicationConstants.NAME1, address);
    	user2 = new User ();
      
    	user1.setId(ApplicationConstants.ID1);
    	user1.setName(ApplicationConstants.NAME1);
    	user1.setAddress(address);
    }
    
    /**
     * Test teardown method.
     */
    @After
    public void teardown ()
    {
    	address = null;
    	user1 = null;
    	user2 = null;
    }
    
    
    /**
     * test get methods.
     */
    @Test
    public void testGetMethods ()
    {
    	assertNotNull (user1.getId());
    	assertNotNull (user1.getName());
    	assertNotNull (user1.getAddress());
    	assertNotNull (user1.toString());
    }

}
