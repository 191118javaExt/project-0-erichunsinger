package com.revature.bankingapp.dao;

import java.util.Set;

import com.revature.bankingapp.model.User;

public interface UserDao 
{
    User getUserById(Long idUser);
    User getUserByUserName(String userName);
    Set<User> getAllUsers();
    User getUserByUserNameAndPassword(String userName, String password);
    boolean insert(User user);
    boolean update(User user);
    boolean delete(String userName);
}
