package com.my.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *  The Class MyApplication.
 * 
 */
@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer {
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MyApplication.class);
		app.run(args);
	}
}
