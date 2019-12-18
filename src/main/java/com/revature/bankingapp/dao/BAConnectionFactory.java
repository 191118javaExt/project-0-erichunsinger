package com.revature.bankingapp.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;

public class BAConnectionFactory {
	
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERID = "eric";
    private static final String PASSWD = "mypassword";
    
    private static DataSource datasource = null;
    
    

    /**

     * Get a connection to database

     * @return Connection object

     */

    public static Connection getConnection()

    {

      try {
    	  if (datasource == null)
    		  datasource = setupDataSource(URL);
          //DriverManager.registerDriver(new Driver());
          return datasource.getConnection();   
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }

    }
    
    public static DataSource setupDataSource(String connectURI) {
    	ConnectionFactory connectionFactory =
              new DriverManagerConnectionFactory(connectURI,USERID,PASSWD);

		PoolableConnectionFactory poolableConnectionFactory =
              new PoolableConnectionFactory(connectionFactory, null);

        ObjectPool<PoolableConnection> connectionPool =
                  new GenericObjectPool<>(poolableConnectionFactory);
          
         poolableConnectionFactory.setPool(connectionPool);

         PoolingDataSource<PoolableConnection> dataSource =
                  new PoolingDataSource<>(connectionPool);
 
         return dataSource;
      }

}
