package com.revature.bankingapp.application;


import com.revature.bankingapp.dao.UserDao;
import com.revature.bankingapp.dao.UserDaoImpl;
import com.revature.bankingapp.model.ConnectionFactory;
import com.revature.bankingapp.model.Customer;
import com.revature.bankingapp.ui.BankUI;


public class BankingApp {
	
	public void run() {
		
		BankUI bankui = new BankUI();
		bankui.process();
	}
	
	
	
	 public BankingApp() {
		super();
	}

	UserDao userdao = new UserDaoImpl();
	 
	 public static void main(String[] args) {
		 
		 BankingApp bankingApp = new BankingApp();
		 bankingApp.run();
	 }
	
/*		public static void main(String[] args) {
			
			runConsole();
  }
/*		public static void runConsole() {
			
			Customer c = new Customer();
			Scanner sc = new Scanner(System.in);
			System.out.println("Please select an option from below\n");
			System.out.println("1. Customer\n2. Employee\n3. Admin");
			
			if(sc.nextInt() == 1) {
				
				System.out.println("Please select an option below\n");
				System.out.println("1. New Customer\n2. Existing Customer");
				
				
				if(sc.nextInt() == 1) {
					
					System.out.println("Please enter your name");
					sc.nextLine();
					c.setName(sc.nextLine());
					System.out.println(c.getName());
					System.out.println("Please enter your address and press enter");
					c.setAddress(sc.nextLine());
					System.out.println(c.getAddress());
					System.out.println("Type in your city and press enter");
					c.setCity(sc.nextLine());
					System.out.println(c.getCity());
					System.out.println("Type in your state and press enter");
					c.setState(sc.nextLine());
					System.out.println(c.getState());
					System.out.println("Type in your zipcode and press enter");
					c.setZipcode(sc.nextLine());
					System.out.println(c.getZipcode());
					System.out.println("Type in a username and press enter");
					c.setUsername(sc.nextLine());
					System.out.println(c.getUsername());
					System.out.println("Enter a password and press enter");
					c.setPassword(sc.nextLine());
					System.out.println(c.getPassword());
					cdi.insertUser(c);
					
				}
			}
		} */
}