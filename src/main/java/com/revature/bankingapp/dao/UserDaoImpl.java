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
import com.revature.bankingapp.model.User;

public class UserDaoImpl implements UserDao {
	
	//private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
	private static final String SQL_GET_USER_BY_ID = "SELECT * FROM BANKAPP.user WHERE iduser=?";
	private static final String SQL_GET_USER_BY_NAME = "SELECT * FROM BANKAPP.user WHERE username=?";
	private static final String SQL_INSERT_USER ="INSERT INTO BANKAPP.user (username, password, role, idcustomer) VALUES (?, ?, ?, ?)";
	private static final String SQL_UPDATE_BY_USERNAME = "UPDATE BANKAPP.user SET username=?, password=?, role=?, idcustomer=? WHERE username=?";
	private static final String SQL_DELETE_BY_USERNAME = "DELETE FROM BANKAPP.user WHERE username=?";

	@Override
	public User getUserById(Long idUser) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		User user = null;

	    try {
	        try {
	    	    conn = BAConnectionFactory.getConnection();

	            ps = conn.prepareStatement(SQL_GET_USER_BY_ID);
	            ps.setLong(1,idUser);
	            rs = ps.executeQuery();

	            if(rs.next())
	            {

	                user = new User();
	                user.setIdUser( rs.getLong("iduser") );
	                user.setUserName(rs.getString("username") );
	                user.setPassword(rs.getString("password") );
	                user.setRole( rs.getString("role") );
	                user.setIdCustomer(rs.getLong("idcustomer") );

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
	    	//logger.log(Level.ERROR,"Error Getting User ",ex);
	    	RvrException.throwRvrException("Error Getting User ", ex);
	    	
	    }
	    return user;

	}
	@Override
	public User getUserByUserName(String userName) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		User user = null;

	    try {
	        try {
	    	    conn = BAConnectionFactory.getConnection();

	            ps = conn.prepareStatement(SQL_GET_USER_BY_NAME);
	            ps.setString(1,userName);
	            rs = ps.executeQuery();

	            if(rs.next())
	            {

	                user = new User();
	                user.setIdUser( rs.getLong("iduser") );
	                user.setUserName(rs.getString("username") );
	                user.setPassword(rs.getString("password") );
	                user.setRole( rs.getString("role") );
	                user.setIdCustomer(rs.getLong("idcustomer") );
	                if (user.getIdCustomer() == 0)
	                	user.setIdCustomer(null);

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
	    	//logger.log(Level.ERROR,"Error Getting User ",ex);
	    	RvrException.throwRvrException("Error Getting User ", ex);
	    	
	    }
	    return user;

	}

	@Override
	public Set<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(User user) {
		
		Boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement ps = null;

		conn = BAConnectionFactory.getConnection();
	    try {
		    try {
	
		        ps = conn.prepareStatement(SQL_INSERT_USER);
	
		        ps.setString(1, user.getUserName());
		        ps.setString(2, user.getPassword());
		        ps.setString(3, user.getRole());
		        ps.setObject(4, user.getIdCustomer());
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
	    	//logger.log(Level.ERROR,"Error Getting User ",ex);
	    	RvrException.throwRvrException("Error Getting User ", ex);
	    	
	    }

	    return isSuccess;
	}

	@Override
	public boolean update(User user) {

		Boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement ps = null;

		conn = BAConnectionFactory.getConnection();
	    try {
	    	try {

	        ps = conn.prepareStatement(SQL_UPDATE_BY_USERNAME);
	        ps.setString(1, user.getUserName());
	        ps.setString(2, user.getPassword());
	        ps.setString(3, user.getRole());
	        ps.setObject(4, user.getIdCustomer());
	        ps.setString(5, user.getUserName());

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
	    	//logger.log(Level.ERROR,"Error Getting User ",ex);
	    	RvrException.throwRvrException("Error Getting User ", ex);
	    	
	    }

	    return isSuccess;

	}

	@Override
	public boolean delete(String userName) {
		
		Boolean isSuccess = false;
		Connection conn = null;

	    conn = BAConnectionFactory.getConnection();
	    PreparedStatement ps = null;
	    
	    try {
		    try {
	
		        ps = conn.prepareStatement(SQL_DELETE_BY_USERNAME);
		        ps.setString(1, userName);
	
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
	    	//logger.log(Level.ERROR,"Error Getting User ",ex);
	    	RvrException.throwRvrException("Error Getting User ", ex);
	    }

	    return isSuccess;

	}

}
