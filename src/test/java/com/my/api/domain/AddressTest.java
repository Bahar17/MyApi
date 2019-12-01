package com.my.api.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.my.api.service.ApplicationConstants;

/**
 * 
 * The Class AddressTest.
 *
 */
public class AddressTest {
	/**
     * Class under test.
     */
	 @SuppressWarnings("unused")
    private Address address1;
    
	/**
     * Class under test.
     */
    private Address address2;
    

    /**
     * Method executed before each test method.
     */
    @Before
    public void setUp ()
    {
    	address1 = new Address();
    	address2 = new Address (ApplicationConstants.ID1, ApplicationConstants.LONDON,
    			ApplicationConstants.POST_CODE);
      
    	address2.setId(ApplicationConstants.ID1);
    	address2.setPostCode(ApplicationConstants.POST_CODE);
    	address2.setCity(ApplicationConstants.LONDON);
    }
    
    /**
     * Test teardown method.
     */
    @After
    public void teardown ()
    {
    	address1 = null;
    	address2 = null;
    }
    
    
    /**
     * test get methods.
     */
    @Test
    public void testGetMethods ()
    {
    	assertNotNull (address2.getId());
    	assertNotNull (address2.getPostCode());
    	assertNotNull (address2.getCity());
    	assertNotNull (address2.toString());
    }

}
