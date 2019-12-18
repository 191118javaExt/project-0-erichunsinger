package com.revature.bankingapp.model;

public class Application {
	

	// Instance variables.
	private Long idAccount;
	private Long idCustomer;
	private String accountType;
	private String description;

	public Application(Long idAccount, Long idCustomer, String accountType, String description) {
		super();
		this.idAccount = idAccount;
		this.idCustomer = idCustomer;
		this.accountType = accountType;
		this.description = description;
	}
	/**
	 * @return the idAccount
	 */
	public Long getIdAccount() {
		return idAccount;
	}
	/**
	 * @param idAccount the idAccount to set
	 */
	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
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
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


}
