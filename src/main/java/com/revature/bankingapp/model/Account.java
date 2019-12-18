/**
 * 
 */
package com.revature.bankingapp.model;

/**
 * @author James
 *
 */
public class Account {
	
	// Instance variables.
	private Long idAccount;
	private Long idCustomer;
	private String accountType;
	private String description;
	private Float balance;
	private String status;
	
	
	public Account() {}

	
	
	
	public Account(Long idAccount, Long idCustomer, String accountType, String description, Float balance,
			String status) {
		super();
		this.idAccount = idAccount;
		this.idCustomer = idCustomer;
		this.accountType = accountType;
		this.description = description;
		this.balance = balance;
		this.status = status;
	}




	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}




	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}




	/**
	 * @return the balance
	 */
	public Float getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Float balance) {
		this.balance = balance;
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




	@Override
	public String toString() {
		return "Account [idAccount=" + idAccount + ", idCustomer=" + idCustomer + ", accountType=" + accountType
				+ ", description=" + description + ", balance=" + balance + ", status=" + status + "]";
	}


	
	
}
