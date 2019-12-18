package com.revature.bankingapp.model;

public class Admin {

	private String name;
	private String address;
	private String city;
	private String state;
	private Integer zipcode;
	private String username;
	private String password;
	
	Admin(){
		
		super();
	}
	
	Admin(String name, String address, String city, String state, Integer zipcode){
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
