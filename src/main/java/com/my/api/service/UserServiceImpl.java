package com.my.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.my.api.Exceptions.UserIdNotFoundException;
import com.my.api.domain.Address;
import com.my.api.domain.User;

import lombok.extern.slf4j.Slf4j;


/**
 * The Class UserServiceImpl.
 * 
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService{
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
	
	@Value("${api.key}")
	private String key;
	
	private static List<User> users = new ArrayList<>();
	
	private static Address address1;
	private static Address address2;
	private static Address address3;
	private static Address address4;
	private static Address address5;
	private static Address address6;
	private static Address address7;
	private static Address address8;
	private static Address address9;
	private static Address address10;
	
	
	private Double lng;
	private Double lat;
	private Double lng2;
	private Double lat2;
	private double d;
	
	
	static {
		//Initialize Data
		address1 = new Address("Address1", ApplicationConstants.LONDON, "N12 6PQ");
		address2 = new Address("Address2", "Reading", "RG1 2PL");
		address3 = new Address("Address3", ApplicationConstants.LONDON, "E12 3RJ");
		address4 = new Address("Address4", ApplicationConstants.LONDON, "W1A 1ER");
		address5 = new Address("Address5", "Leatherhead", "KT22 9LP");
		address6 = new Address("Address6", "Bath", "BA2 6AE");
		address7 = new Address("Address7", ApplicationConstants.LONDON, "E1 4NY");
		address8 = new Address("Address8", "Leeds", "LS10 1LT");
		address9 = new Address("Address9", "Norwich", "NR1 1RQ");
		address10 = new Address("Address10", "Woking", "GU22 7BD");
		
		
		 User User1 = new User("1", "Ava Smith", address1);
	     User User2 = new User("2", "Leo Jones", address2);
	     User User3 = new User("3", "Jacob Williams", address3);
		 User User4 = new User("4", "Henry Taylor", address4);
	     User User5 = new User("5", "Freddie Davies", address5);
	     User User6 = new User("6", "Amelia Evans", address6);
		 User User7 = new User("7", "Oscar Johnson", address7);
	     User User8 = new User("8", "Rose Roberts", address8);
	     User User9 = new User("9", "Elsa Robinson", address9);
	     User User10 = new User("10", "Alice Watt", address10);
	     
	     users.add(User1);
	     users.add(User2);
	     users.add(User3);
	     users.add(User4);
	     users.add(User5);
	     users.add(User6);
	     users.add(User7);
	     users.add(User8);
	     users.add(User9);
	     users.add(User10);
	 }
	 
	 /**
     * getAllUsers.
     * 
     */
	@Override
	 public List<User> getAllUsers() {
		// Return all users.
	    return users;
	 }

	
	 /**
     * getUserById.
     * 
     * @param String id
     */
	 @Override
	 public User getUserById(String id) throws UserIdNotFoundException { 
	    for(User user : users) {
	      //Check for the user id
	      if(user.getId().equals(id)) {
	       return user;
	      }
	    }
	   return null;
	 }
	 
	 
	 /**
	  * getUsersByCity.
	  * 
	  * @param String city
	  */
	 @Override
	public List<User> getUsersByCity(String city) throws IOException {
		LOGGER.debug("Starting get people by city {}", city);
		List<User> userList = new ArrayList<>();
		
		//Check if the city is not London, calculate the distance between the city and London
		if(!city.equalsIgnoreCase(ApplicationConstants.LONDON)) {
			//Calling OpenCage Geocoding api to get the coordinates of the city
			getCoordiantions(city);
		    lat2 = lat;	
			lng2 = lng;
		    d = distance(ApplicationConstants.LNG1, ApplicationConstants.LAT1, lat2,lng2, "M");
		}
		//Get all people who are listed as either living in London, 
		//or whose current coordinates are within 50 miles of London
		if(d<=50.00 || city.equalsIgnoreCase(ApplicationConstants.LONDON)) {
		  for(User user : users) {
			if(user.getAddress().getCity().equalsIgnoreCase(city)){
				userList.add(user);
			 }	
		  }
		}
		LOGGER.debug("Finishing get people by city {}", city);
		return userList;
	}
	 
	 
	 /**
	  * getInstructions.
	  * 
	  */
	 @Override
	  public String getInstructions() {
		 return ApplicationConstants.INSTRUCTIONS;
	 }
	 
	 
	 /**
	  * getCoordiantions.
	  * 
	  * @param String city
	  * 
	  */
	  public void getCoordiantions(String city) throws IOException {
		  JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(key);
		  JOpenCageForwardRequest request = new JOpenCageForwardRequest(city);
		  request.setLimit(1);
		  request.setNoAnnotations(true);
		  JOpenCageResponse response = jOpenCageGeocoder.forward(request);

		  if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
			   JOpenCageLatLng coordinates = response.getResults().get(0).getGeometry();
			   lng = coordinates.getLng();
			   lat = coordinates.getLat();
		  } else {
			  LOGGER.debug("Unable to geocode input address:{} " + city);
		  }
		  try {
			   Thread.sleep(1000); 
		  } catch (InterruptedException e) {
			  LOGGER.error("Interrupted exception"+ e);
		  }
	  }
	  

      /**
	   * distance.
	   * 
	   * @param double lat1
	   * @param double lon1
	   * @param double lat2
	   * @param double lon2
	   * @param String unit
	   * 
	   */
	  public double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
			if ((lat1 == lat2) && (lon1 == lon2)) {
				return 0;
			}
			else {
				double theta = lon1 - lon2;
				double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) +
						Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) 
						* Math.cos(Math.toRadians(theta));
				dist = Math.acos(dist);
				dist = Math.toDegrees(dist);
				dist = dist * 60 * 1.1515;
				if (unit.equals("K")) {
					dist = dist * 1.609344;
				} else if (unit.equals("N")) {
					dist = dist * 0.8684;
				}
				return (dist);
			}
		}
}
