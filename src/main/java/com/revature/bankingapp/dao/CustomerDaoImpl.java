package com.revature.bankingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/*import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; */

import com.revature.bankingapp.RvrException;
import com.revature.bankingapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	//private static final Logger logger = LogManager.getLogger(CustomerDaoImpl.class);
	private static final String SQL_GET_Customer_BY_ID = "SELECT * FROM BANKAPP.CUSTOMER WHERE idCustomer=?";
	private static final String SQL_GET_Customer_BY_SSN = "SELECT * FROM BANKAPP.CUSTOMER WHERE ssn=?";
	private static final String SQL_INSERT_Customer ="INSERT INTO BANKAPP.CUSTOMER (name, ssn, address1, address2, city,state,zipcode) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE_BY_CustomerId = "UPDATE BANKAPP.CUSTOMER SET name=?, ssn=?, address1=?, address2=?, city=?, state=?, zipcode=? WHERE idcustomer=?";
	private static final String SQL_DELETE_BY_CustomerId = "DELETE FROM BANKAPP.CUSTOMER WHERE idcustomer=?";

	@Override
	public Customer getCustomerById(Long idCustomer) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		Customer Customer = null;

	    try {
	        try {
	    	    conn = BAConnectionFactory.getConnection();

	            ps = conn.prepareStatement(SQL_GET_Customer_BY_ID);
	            ps.setLong(1,idCustomer);
	            rs = ps.executeQuery();

	            if(rs.next())
	            {

	                Customer = new Customer();
	                Customer.setIdCustomer( rs.getLong("idCustomer") );
	                Customer.setName(rs.getString("name") );
	                Customer.setSsn(rs.getString("ssn") );
	                Customer.setAddress1(rs.getString("address1") );
	                Customer.setAddress2( rs.getString("address2") );
	                Customer.setCity(rs.getString("city") );
	                Customer.setZipcode(rs.getString("zipcode") );

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
	    	//logger.log(Level.ERROR,"Error Getting Customer ",ex);
	    	RvrException.throwRvrException("Error Getting Customer ", ex);
	    	
	    }
	    return Customer;

	}
	
	@Override
	public Customer getCustomerBySsn(String ssn) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		Customer Customer = null;

	    try {
	        try {
	    	    conn = BAConnectionFactory.getConnection();

	            ps = conn.prepareStatement(SQL_GET_Customer_BY_SSN);
	            ps.setString(1,ssn);
	            rs = ps.executeQuery();

	            if(rs.next())
	            {

	                Customer = new Customer();
	                Customer.setIdCustomer( rs.getLong("idCustomer") );
	                Customer.setName(rs.getString("name") );
	                Customer.setSsn(rs.getString("ssn") );
	                Customer.setAddress1(rs.getString("address1") );
	                Customer.setAddress2( rs.getString("address2") );
	                Customer.setCity(rs.getString("city") );
	                Customer.setZipcode(rs.getString("zipcode") );

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
	    	//logger.log(Level.ERROR,"Error Getting Customer ",ex);
	    	RvrException.throwRvrException("Error Getting Customer ", ex);
	    	
	    }
	    return Customer;

	}
	

/*	@Override
	public Set<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	} */

	@Override
	public boolean insert(Customer Customer) {
		
		Boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement ps = null;

		conn = BAConnectionFactory.getConnection();
	    try {
		    try {
	
		        ps = conn.prepareStatement(SQL_INSERT_Customer);
	
		        ps.setString(1, Customer.getName());
		        ps.setString(2, Customer.getSsn());
		        ps.setString(3, Customer.getAddress1());
		        ps.setString(4, Customer.getAddress2());
		        ps.setString(5, Customer.getCity());
		        ps.setString(6, Customer.getState());
		        ps.setString(7, Customer.getZipcode());
		        
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
	    	//logger.log(Level.ERROR,"Error Getting Customer ",ex);
	    	RvrException.throwRvrException("Error Getting Customer ", ex);
	    	
	    }

	    return isSuccess;
	}

	@Override
	public boolean update(Customer Customer) {

		Boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement ps = null;

		conn = BAConnectionFactory.getConnection();
	    try {
	    	try {

	        ps = conn.prepareStatement(SQL_UPDATE_BY_CustomerId);
	        ps.setString(1, Customer.getName());
	        
	        ps.setString(1, Customer.getName());
	        ps.setString(2, Customer.getSsn());
	        ps.setString(3, Customer.getAddress1());
	        ps.setString(4, Customer.getAddress2());
	        ps.setString(5, Customer.getCity());
	        ps.setString(6, Customer.getState());
	        ps.setString(7, Customer.getZipcode());
	        ps.setLong(8, Customer.getIdCustomer());
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
	    	//logger.log(Level.ERROR,"Error Getting Customer ",ex);
	    	RvrException.throwRvrException("Error Getting Customer ", ex);
	    	
	    }

	    return isSuccess;

	}

	@Override
	public boolean delete(Long idCustomer) {
		
		Boolean isSuccess = false;
		Connection conn = null;

	    conn = BAConnectionFactory.getConnection();
	    PreparedStatement ps = null;
	    
	    try {
		    try {
	
		        ps = conn.prepareStatement(SQL_DELETE_BY_CustomerId);
		        ps.setLong(1, idCustomer);
	
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
	    	//logger.log(Level.ERROR,"Error Getting Customer ",ex);
	    	RvrException.throwRvrException("Error Getting Customer ", ex);
	    }

	    return isSuccess;

	}

}
