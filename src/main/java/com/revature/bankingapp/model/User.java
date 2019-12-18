
package com.revature.bankingapp.model;

import java.util.List;
import java.util.Set;

public class User {
	
	// Instance variables
	private Long idUser;
	private String userName;
	private String password;
	private Long idCustomer;
	private String role;

	
	
	
	public User(Long idUser, String userName, String password,  String role, Long idCustomer) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.password = password;
		this.idCustomer = idCustomer;
		this.role = role;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	/**
	 * @return the idUser
	 */
	public Long getIdUser() {
		return idUser;
	}
	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", userName=" + userName + ", password=" + password + ", idCustomer="
				+ idCustomer + ", role=" + role + "]";
	}
	
	


}
