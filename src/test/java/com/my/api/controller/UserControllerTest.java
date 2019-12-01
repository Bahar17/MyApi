package com.my.api.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.api.domain.Address;
import com.my.api.domain.User;
import com.my.api.service.ApplicationConstants;
import com.my.api.service.UserServiceImpl;

/**
 * 
 * The Class UserControllerTest.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class UserControllerTest {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(UserControllerTest.class);

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private UserServiceImpl mockUserServiceImpl;
    
    private ObjectMapper om;
    
    private User user;
    
    private Address address;
    
    private List<User> users;
    
    private ResponseEntity<String> response;
    
    private String expected;


    /**
     * Method executed before each test method.
     */
    @Before
    public void setUp() throws Exception {
    	om = new ObjectMapper();
        address = new Address();
    	address.setId("address1");
    	address.setPostCode(ApplicationConstants.POST_CODE);
    	address.setCity(ApplicationConstants.LONDON);
    	
    	user = new User();
    	user.setId(ApplicationConstants.ID1);
    	user.setName(ApplicationConstants.NAME1);
    	user.setAddress(address);
    	
    	users = new ArrayList<>();
    	users.add(user);
    }
    
	@After
	public void tearDown() {
		om = null;
		address = null;
		user = null;
		users = null;
	}

    /**
     * Test getUserById completes successfully.
     * @throws Exception 
     */
    @Test
    public void findUsersById() throws Exception {
    	
    	Mockito.when(mockUserServiceImpl.getUserById(ApplicationConstants.ID1)).thenReturn(user);

        expected = "{id:\"1\",name:\"John Smith\",address:{id:\"address1\",city:\"London\",postCode:\"N12 6PQ\"}}";

        response = restTemplate.getForEntity("/user/1", String.class);

        printJSON(response);

        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        JSONAssert.assertEquals(expected, response.getBody(), false);
        
        Mockito.verify(mockUserServiceImpl, Mockito.atLeastOnce()).getUserById(ApplicationConstants.ID1);

    }
    
    /**
     * Test getUserById not found.
     * @throws Exception 
     */
    @Test
    public void findUserId_NotFound_404() throws Exception {

        response = restTemplate.getForEntity("/user/5", String.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    
    /**
     * Test getAllUsers completes successfully.
     * @throws Exception 
     */
    @Test
    public void findAllUsers() throws Exception {

        List<User> users = Arrays.asList(
                new User(ApplicationConstants.ID1, ApplicationConstants.NAME1, address),
                new User(ApplicationConstants.ID2, ApplicationConstants.NAME2, address));

        Mockito.when(mockUserServiceImpl.getAllUsers()).thenReturn(users);

        expected = om.writeValueAsString(users);

        response = restTemplate.getForEntity("/users", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expected, response.getBody(), false);

        Mockito.verify(mockUserServiceImpl, Mockito.times(1)).getAllUsers();
    }
    
    /**
     * Test getUsersByCity completes successfully.
     * @throws Exception 
     */
    @Test
    public void findUsersByCity() throws Exception {
    	
    	Mockito.when(mockUserServiceImpl.getUsersByCity(ApplicationConstants.LONDON)).thenReturn(users);

        response = restTemplate
                .getForEntity("/city/"+ApplicationConstants.LONDON+"/users", String.class);

        printJSON(response);

        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        
        Mockito.verify(mockUserServiceImpl, Mockito.atLeastOnce()).getUsersByCity(ApplicationConstants.LONDON);    
    }
    
    
    /**
     * Test getUsersByCity city is not London completes successfully.
     * @throws Exception 
     */
    @Test
    public void findUsersByCityNotLondon() throws Exception {
    	
    	Mockito.when(mockUserServiceImpl.getUsersByCity(ApplicationConstants.LEEDS)).thenReturn(users);

        response = restTemplate
                .getForEntity("/city/"+ApplicationConstants.LEEDS+"/users", String.class);

        printJSON(response);

        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        
        Mockito.verify(mockUserServiceImpl, Mockito.atLeastOnce()).getUsersByCity(ApplicationConstants.LEEDS);    
    }
    
    /**
     * Test getInstructions completes successfully.
     * @throws Exception 
     */
    @Test
    public void findInstructions() throws Exception {

        Mockito.when(mockUserServiceImpl.getInstructions()).thenReturn(ApplicationConstants.INSTRUCTIONS);

        expected = om.writeValueAsString(ApplicationConstants.INSTRUCTIONS);

        response = restTemplate.getForEntity("/instructions", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, response.getBody(), ApplicationConstants.INSTRUCTIONS);

        Mockito.verify(mockUserServiceImpl, Mockito.times(1)).getInstructions();
    }
    
    private void printJSON(Object object) {
        String result;
        try {
            result = om.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(result);
        } catch (JsonProcessingException e) {
        	LOGGER.error("JsonProcessing Exception"+ e);
        	
        }
    }

}
