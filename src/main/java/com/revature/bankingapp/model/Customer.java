package com.revature.bankingapp.model;

import java.util.List;

public class Customer {
	
	// Instance variables
	private Long idCustomer;
	private String ssn;
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipcode;
	
	private User user;
	private List<Account> accounts;
	
	// Constructors
	public Customer () {}
	public Customer (
			String name
			,String ssn
			,String address1
			,String address2
			,String city
			,String state
			,String zipcode
			) {
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	// Methods
	
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the accounts
	 */
	public List<Account> getAccounts() {
		return accounts;
	}
	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	/**
	 * @return the idCustomer
	 */
	public Long getIdCustomer() {
		return idCustomer;
	}

	/**
	 * @param idCustomer the idCustomer to set
	 */
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", name=" + name + ", address1=" + address1 + ", address2="
				+ address2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	

}


