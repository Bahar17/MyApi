package com.my.api.domain;

/**
 *  The Class Address.
 * 
 */
public class Address {
	
	private String id;
	private String city;
	private String postCode;
	
	public Address() {
		 super();
	 }
	 
	 public Address(String id, String city, String postCode) {
		 super();
		 this.id =id;
		 this.city =city;
		 this.postCode = postCode; 
	 }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	@Override
	public String toString() {
		return "Id : " + id + ", City : " + city + ", PostCode : " + postCode;
	}
}
