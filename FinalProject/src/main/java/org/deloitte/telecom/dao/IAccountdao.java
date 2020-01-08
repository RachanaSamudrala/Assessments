package com.deloitte.telcom.dao;

import java.util.Map;

import com.deloitte.telcom.entity.Account;

public interface IAccountdao {

	Account accountBalanceEnquiry(String mobileNo);
	
	Account rechargeAccount(String mobileNo , double amount); 
	
	Account createAccount(String name , String mobileNo , String accountType , double balance);

	public Map<String , Account> getStore();
	
	Account findAccountByMobileNo(String mobileNo);
}
