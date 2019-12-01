package com.my.api.domain;

/**
 *  The Class User.
 * 
 */
public class User {
	
	 private String id;
	 private String name;
	 private Address address;
	 
	 public User() {
		 super();
	 }
	 
	 public User(String id, String name, Address address) {
		 super();
		 this.id =id;
		 this.name =name;
		 this.address = address; 
	 }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", Address : " + address;
	}
}
