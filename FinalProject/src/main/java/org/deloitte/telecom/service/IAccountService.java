package com.deloitte.telcom.service;

import com.deloitte.telcom.entity.Account;

public interface IAccountService {
	

	Account accountBalanceEnquiry(String mobileNo);
	
	Account rechargeAccount(String mobileNo , double amount);
	
	Account createAccount(String name , String mobileNo , String accountType , double balance);
	
	Account findAccountByMobileNo(String mobileNo); 
	
}
