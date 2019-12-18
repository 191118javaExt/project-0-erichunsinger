package com.revature.bankingapp.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.bankingapp.model.User;




/**
 * Unit test for simple App.
 */
public class UserTest

{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	@Test
    public void UserDaoTest()
    {
        UserDao userDao = new UserDaoImpl();
        User user = null;
		try {
			
			// remove user;
			//assertTrue(userDao.delete("ericCustomer") );
			
			// create new user;
			user = new User( (Long) null,"jscust","passwd1", "Customer" , (Long) null);
			assertTrue( userDao.insert(user) );		
			
			// get the user
	        user = userDao.getUserByUserName(user.getUserName());
	        System.out.println (user.toString());
	        
	        // update the user
	        user.setPassword("passwd");
	        assertTrue( userDao.update(user));
	        System.out.println (user.toString());
	        
	        // delete user
	        assertTrue(userDao.delete(user.getUserName()) );
	        
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
    }

    /**
     * @return the suite of tests being tested
     */

}
