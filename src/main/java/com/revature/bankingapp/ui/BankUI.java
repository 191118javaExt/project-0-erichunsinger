package com.revature.bankingapp.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import com.revature.bankingapp.dao.AccountDao;
import com.revature.bankingapp.dao.AccountDaoImpl;
import com.revature.bankingapp.dao.CustomerDao;
import com.revature.bankingapp.dao.CustomerDaoImpl;
import com.revature.bankingapp.dao.UserDao;
import com.revature.bankingapp.dao.UserDaoImpl;
import com.revature.bankingapp.model.Account;
import com.revature.bankingapp.model.Customer;
import com.revature.bankingapp.model.User;

public class BankUI {
	Scanner sc = new Scanner(System.in);
	private User currentUser;
	private Customer currentCustomer;
	
	public BankUI () {
	}
	
	public void process() {
		
		User user = new User();
		UserDao userDao = new UserDaoImpl();
		AccountDao accountDao = new AccountDaoImpl();
		CustomerDao customerDao = new CustomerDaoImpl();
		Boolean notDone = true;
		Boolean  isLoggedIn = false;
		
		// Login user or register,
		while (!isLoggedIn) {		
		System.out.println(
				"Please login in or register as a new user\n"
				+ "1 - Login\n"
				+ "2 - Register\n"
				+ "3 - Quit\n"
				+ ">");

			String userInput = sc.nextLine();
			if(userInput.equals( "1") )
				isLoggedIn = processLogin();
			else if  (userInput.equals( "2") )
				isLoggedIn = registrationProcess();
			else
				return;
		}
		// logged in
		
		
		while (isLoggedIn) {
			// User from login so create customer
			currentCustomer = customerDao.getCustomerById(currentUser.getIdCustomer());
			currentCustomer.setUser(user);
			List<Account> accounts = accountDao.getAccountsByCustomerId(currentUser.getIdCustomer());
			currentCustomer.setAccounts(accounts);
			
			
			if (currentUser.getRole().equals("Customer")) {
				
				System.out.println(
						"Your Accounts:"
						);
				Iterator<Account> ai = accounts.iterator();
				while (ai.hasNext()) {
					Account acct = ai.next();
					System.out.println(acct.toString());
				}
				
				
				System.out.println(
						"Please select an option:\n"
						+ "1 - Open account\n"
						+ "2 - Withdrawl from account\n"
						+ "3 - Deposit into account\n"
						+ "4 - Transfer funds between accounts\n"
						+ ">"
						);
				switch (sc.nextLine()) {
					case "1":
						openAccount();
						break;
					case "2":
						withdrawlAccount();
						break;
					case "3":
						depositAccount();
						break;
					case "4":
						transferAccount();
						break;
				}
				
			}
			if (currentUser.getRole().equals("Employee")) {
				
			}
			if (currentUser.getRole().equals("Admin")) {
			
			}
		}
	}
	
	private Boolean processLogin() {
		
		String username;
		String password;
		UserDao userDao = new UserDaoImpl();
		Boolean isLoggedIn = false;
		//System.out.println("Please enter your username and password when prompted:\n");
		System.out.println("Please enter your username:\n");
		username = sc.nextLine();
		System.out.println("Please enter your password:\n");
		password = sc.nextLine();
		
		this.currentUser = null;
		User user = new User();
		
		User dbUser = userDao.getUserByUserName(username);
		if (dbUser != null) {
			if (dbUser.getPassword().equals(password)) {
				isLoggedIn = true;
				this.currentUser = dbUser;
			}
			
		}
		return isLoggedIn;
		
	}
	
	private Boolean registrationProcess() {
		
		User user = new User();
		Customer customer = new Customer();
		Account account = new Account();
		Boolean isSuccess = false;
		
		UserDao userDao = new UserDaoImpl();
		CustomerDao customerDao = new CustomerDaoImpl();
		AccountDao accountDao = new AccountDaoImpl();
		
		System.out.println("Please enter your Registration Information\n");
		// user info
		System.out.println ("Enter username:\n>");
		user.setUserName(sc.nextLine());
		System.out.println ("Enter password:\n>");
		user.setPassword(sc.nextLine());
		user.setRole("Customer");
		
		// customer info
		System.out.println ("Enter full name:\n>");
		customer.setName(sc.nextLine());
		System.out.println ("Enter your Social Security number:\n>");
		customer.setSsn(sc.nextLine());
		System.out.println ("Enter street address:\n>");
		customer.setAddress1(sc.nextLine());
		customer.setAddress2("");
		System.out.println ("Enter city:\n>");
		customer.setCity(sc.nextLine());
		System.out.println ("Enter state:\n>");
		customer.setState(sc.nextLine());
		System.out.println ("Enter zip code:\n>");
		customer.setZipcode(sc.nextLine());
		
		
		customerDao.insert(customer);
		customer = customerDao.getCustomerBySsn(customer.getSsn());
		user.setIdCustomer(customer.getIdCustomer());
		userDao.insert(user);
		customer.setUser(user);
		this.currentUser = user;
		isSuccess = true;
		return isSuccess;
	}
	
	public void openAccount () {
		String userInput;
		Account account = new Account();
		AccountDao accountDao = new AccountDaoImpl();
		
		// account info
		System.out.println ("Enter  1 - Checking 2 - Savings");
		if (sc.nextLine().equals( "1") )
			account.setAccountType("Checking");
		else
			account.setAccountType("Savings");
		System.out.println ("Enter a description for the account:\n");
		account.setDescription(sc.nextLine());
		account.setBalance(new Float(0.0f));
		account.setStatus("Pending Approval");
		account.setIdCustomer(this.currentUser.getIdCustomer());
		accountDao.insert(account);
		
		System.out.println("Account added");
	}
	
	public void withdrawlAccount () {
		System.out.println("Enter account number");
		String idAccount = sc.nextLine();
		System.out.println("Enter amount");
		String amnt = sc.nextLine();
		AccountDao accountDao = new AccountDaoImpl();
		Account account = accountDao.getAccountById(Long.valueOf(idAccount));
		Float f = account.getBalance() - Float.valueOf(amnt);
		account.setBalance(f);
		accountDao.update(account);
		
	}

	public void depositAccount() {
		System.out.println("Enter account number");
		String idAccount = sc.nextLine();
		System.out.println("Enter amount");
		String amnt = sc.nextLine();
		AccountDao accountDao = new AccountDaoImpl();
		Account account = accountDao.getAccountById(Long.valueOf(idAccount));
		Float f = account.getBalance().floatValue() + Float.valueOf(amnt).floatValue();
		account.setBalance(f);
		accountDao.update(account);
	}
	
	public void transferAccount() {
		System.out.println("Enter from account number");
		String fromAcctNbr = sc.nextLine();
		System.out.println("Enter to account number");
		String toAcctNbr = sc.nextLine();
		System.out.println("Enter amount");
		String amnt = sc.nextLine();
		AccountDao accountDao = new AccountDaoImpl();
		Account fromAcct = accountDao.getAccountById(Long.valueOf(fromAcctNbr));
		Account toAcct = accountDao.getAccountById(Long.valueOf(toAcctNbr)); 
		fromAcct.setBalance(fromAcct.getBalance() - Float.valueOf(amnt));
		toAcct.setBalance(toAcct.getBalance() + Float.valueOf(amnt));
		accountDao.update(fromAcct);
		accountDao.update(toAcct);
	}
}
