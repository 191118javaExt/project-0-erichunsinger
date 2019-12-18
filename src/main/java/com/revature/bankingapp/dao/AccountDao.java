package com.revature.bankingapp.dao;

import java.util.List;
import java.util.Set;

import com.revature.bankingapp.model.Account;

public interface AccountDao 
{
    Account getAccountById(Long idAccount);
    //Account getCustAccountName(String AccountName);
    List<Account> getAccountsByCustomerId(Long customerId);
    boolean insert(Account Account);
    boolean update(Account Account);
    boolean delete(Long idAccount);
}
