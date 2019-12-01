package com.my.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.my.api.domain.Address;
import com.my.api.domain.User;

/**
 * 
 * The Class UserServiceImplTest.
 *
 */
public class UserServiceImplTest {
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
    private User user1;
    
    private Address address1;
    
    private Address address2;
    
    private List<User> users;
   
	
	 /**
     * Method executed before each test method.
     */
    @Before
    public void setUp ()
    {
    	userServiceImpl = new UserServiceImpl();
    	
    	address1 = new Address();
    	address1.setId("address1");
    	address1.setPostCode(ApplicationConstants.POST_CODE);
    	address1.setCity(ApplicationConstants.LONDON);
    	
    	address2 = new Address();
    	address2.setId("address5");
    	address2.setPostCode(ApplicationConstants.POST_CODE);
    	address2.setCity("Leatherhead");
    	
    	user1 = new User();
    	user1.setId(ApplicationConstants.ID1);
    	user1.setName(ApplicationConstants.NAME1);
    	user1.setAddress(address1);
    	
    	users = new ArrayList<>();
    	users.add(user1);
    }
    
    /**
     * Test teardown method.
     */
    @After
    public void teardown ()
    {
    	address1 = null;
    	address2 = null;
    	user1 = null;
    	users = null;
    }
    
    
    /**
     * test getAllUsers methods.
     */
    @Test
    public void testGetAllUsers ()
    {
    	List<User> users = userServiceImpl.getAllUsers();
    	assertNotNull(users);
    }
    
    /**
     * test getUserById methods.
     */
    @Test
    public void testGetUserById ()
    {
    	User user = userServiceImpl.getUserById(ApplicationConstants.ID1);
    	assertNotNull(user);
    	assertEquals(user.getId(), ApplicationConstants.ID1);
    }
    
    /**
     * test getUserById methods.
     */
    @Test
    public void testGetUserByIdNull ()
    {
    	User user = userServiceImpl.getUserById("20");
    	assertNull(user);
    }
    
    /**
     * test getInstructions methods.
     */
    @Test
    public void testGetInstructions ()
    {
    	String result = userServiceImpl.getInstructions();
    	assertNotNull(result);
    }
    
    /**
     * test getUsersByCity methods.
     * @throws IOException 
     */
    @Test
    public void testGetUsersByCity () throws IOException
    {
    	List<User> users = userServiceImpl.getUsersByCity(ApplicationConstants.LONDON);	
    	assertEquals(users.get(0).getAddress().getCity(), ApplicationConstants.LONDON);
    	assertNotNull(users);
    }
    
}
