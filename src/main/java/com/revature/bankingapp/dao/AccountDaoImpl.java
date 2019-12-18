package com.revature.bankingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; */

import com.revature.bankingapp.RvrException;
import com.revature.bankingapp.model.Account;

public class AccountDaoImpl implements AccountDao {
	
	//private static final Logger logger = LogManager.getLogger(AccountDaoImpl.class);
	private static final String SQL_GET_Account_BY_ID = "SELECT * FROM BANKAPP.Account WHERE idAccount=?";
	private static final String SQL_GET_Accounts_BY_CUSTOMERID = "SELECT * FROM BANKAPP.Account WHERE idcustomer=?";
	private static final String SQL_INSERT_Account ="INSERT INTO BANKAPP.Account (idcustomer, accounttype, description, balance, status) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE_BY_AccountId = "UPDATE BANKAPP.Account SET idcustomer=?, accounttype=?, description=?, balance=?, status=? WHERE idAccount=?";
	private static final String SQL_DELETE_BY_AccountId = "DELETE FROM BANKAPP.Account WHERE idAccount=?";

	@Override
	public Account getAccountById(Long idAccount) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		Account account = null;

	    try {
	        try {
	    	    conn = BAConnectionFactory.getConnection();

	            ps = conn.prepareStatement(SQL_GET_Account_BY_ID);
	            ps.setLong(1,idAccount);
	            rs = ps.executeQuery();

	            if(rs.next()){

	            	account = new Account();
	            	account.setIdAccount( rs.getLong("idaccount") );
	            	account.setIdCustomer(rs.getLong("idcustomer") );
	            	account.setAccountType(rs.getString("accounttype") );
	            	account.setDescription(rs.getString("description") );
	            	account.setBalance(rs.getFloat("balance") );
	            	account.setStatus(rs.getString("status") );

	            }

	        } catch (SQLException ex) {
	        	
	            ex.printStackTrace();

	        }
	        finally {
	        	if (rs != null) 
	        		rs.close();
	        	if (ps != null) 
	        		ps.close();
	        	if (conn != null) 
	        		conn.close();
	        }
	    } catch (SQLException ex){
	    	//logger.log(Level.ERROR,"Error Getting Account ",ex);
	    	RvrException.throwRvrException("Error Getting Account ", ex);
	    	
	    }
	    return account;

	}
	

	@Override
	public List<Account> getAccountsByCustomerId(Long idCustomer) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		List<Account> accounts = new ArrayList<Account>();
		Account account = null;

	    try {
	        try {
	    	    conn = BAConnectionFactory.getConnection();

	            ps = conn.prepareStatement(SQL_GET_Accounts_BY_CUSTOMERID);
	            ps.setLong(1,idCustomer);
	            rs = ps.executeQuery();

	            while(rs.next()){

	                account = new Account();
	                account.setIdAccount( rs.getLong("idaccount") );
	                account.setIdCustomer(rs.getLong("idcustomer") );
	                account.setAccountType(rs.getString("accounttype") );
	                account.setDescription(rs.getString("description") );
	                account.setBalance(rs.getFloat("balance") );
	                account.setStatus(rs.getString("status") );
	                accounts.add(account);
	            }

	        } catch (SQLException ex) {
	            ex.printStackTrace();

	        }
	        finally {
	        	if (rs != null) 
	        		rs.close();
	        	if (ps != null) 
	        		ps.close();
	        	if (conn != null) 
	        		conn.close();
	        }
	    } catch (SQLException ex){
	    	//logger.log(Level.ERROR,"Error Getting Account ",ex);
	    	RvrException.throwRvrException("Error Getting Account ", ex);
	    	
	    }
	    return accounts;
	} 

	@Override
	public boolean insert(Account Account) {
		
		Boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement ps = null;

		conn = BAConnectionFactory.getConnection();
	    try {
		    try {
	
		        ps = conn.prepareStatement(SQL_INSERT_Account);
	
		        ps.setLong(1, Account.getIdCustomer());
		        ps.setString(2, Account.getAccountType());
		        ps.setString(3, Account.getDescription());
		        ps.setFloat(4, Account.getBalance());
		        ps.setString(5, Account.getStatus());
		        int i = ps.executeUpdate();
	
			    if(i == 1) 
			        isSuccess = true;

	        } catch (SQLException ex) {
	        	
	            ex.printStackTrace();

	        }
	        finally {
	        	if (ps != null) 
	        		ps.close();

	        	if (conn != null) 
	        		conn.close();
	        }
	    } catch (SQLException ex){
	    	//logger.log(Level.ERROR,"Error Getting Account ",ex);
	    	RvrException.throwRvrException("Error Getting Account ", ex);
	    	
	    }

	    return isSuccess;
	}

	@Override
	public boolean update(Account Account) {

		Boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement ps = null;

		conn = BAConnectionFactory.getConnection();
	    try {
	    	try {

	        ps = conn.prepareStatement(SQL_UPDATE_BY_AccountId);
	        ps.setLong(1, Account.getIdCustomer());
	        ps.setString(2, Account.getAccountType());
	        ps.setString(3, Account.getDescription());
	        ps.setFloat(4, Account.getBalance());
	        ps.setString(5, Account.getStatus());
	        ps.setLong(6, Account.getIdAccount());
	        int i = ps.executeUpdate();

	      if(i == 1) {
	    	  isSuccess = true;

	      }

	        } catch (SQLException ex) {
	        	
	            ex.printStackTrace();

	        }
	        finally {
	        	if (ps != null) 
	        		ps.close();

	        	if (conn != null) 
	        		conn.close();
	        }
	    } catch (SQLException ex){
	    	//logger.log(Level.ERROR,"Error Getting Account ",ex);
	    	RvrException.throwRvrException("Error Getting Account ", ex);
	    	
	    }

	    return isSuccess;

	}

	@Override
	public boolean delete(Long idAccount) {
		
		Boolean isSuccess = false;
		Connection conn = null;

	    conn = BAConnectionFactory.getConnection();
	    PreparedStatement ps = null;
	    
	    try {
		    try {
	
		        ps = conn.prepareStatement(SQL_DELETE_BY_AccountId);
		        ps.setLong(1, idAccount);
	
		        int i = ps.executeUpdate();
	
		        if(i == 1) 
		    	  	isSuccess = true;
	
	        } catch (SQLException ex) {
	        	
	            ex.printStackTrace();
	
	        }
	        finally {
	        	if (ps != null) 
	        		ps.close();
	
	        	if (conn != null) 
	        		conn.close();
	        }
	    } catch (SQLException ex){
	    	//logger.log(Level.ERROR,"Error Getting Account ",ex);
	    	RvrException.throwRvrException("Error Getting Account ", ex);
	    }

	    return isSuccess;

	}

}
