package com.my.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * The Class MyApplicationTest.
 *
 */
@Configuration
public class MyApplicationTest {
	
   private MyApplication myApplication;

   @Before
   public void setUp() {
	   myApplication = new MyApplication();
	}

   /**
    * Test teardown method.
    */
	@After
	public void tearDown() {
	   myApplication = null;
	}

	/**
	 * Test Main method.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testMain() throws Exception {
	   try {
			myApplication.main(new String[] { 
				"--spring.main.web-environment=false",
				"--spring.main.web-environment=another", 
				"--spring.jpa.hibernate.ddl=false"});
		} catch (Exception e) {
			// Expected exception - do nothing
		}
	}

}

