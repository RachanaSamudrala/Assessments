package com.deloitte.telcom.dao;

import java.util.HashMap;
import java.util.Map;

import com.deloitte.telcom.entity.Account;
import com.deloitte.telcom.exceptions.AccountNotFoundException;
import com.deloitte.telcom.exceptions.CustomerAlreadyExists;
import com.deloitte.telcom.exceptions.IncorrectMobileNoException;
import com.deloitte.telcom.exceptions.MobileNoDoesNotExists;

public class AccountDaoImpl implements IAccountdao {
	
	private Map<String , Account> store = new HashMap<>();
	
	public Map<String , Account> getStore()
	{
		return store;
	}

	
	@Override
	public Account accountBalanceEnquiry(String mobileNo) {
		
		if(store.containsKey(mobileNo))
		{
			Account a = store.get(mobileNo);
			return a;
		}
		else
		{
			throw new MobileNoDoesNotExists("mobile no does not exists");
		}
		
	}

	@Override
	public Account rechargeAccount(String mobileNo , double amount) {

		if(store.containsKey(mobileNo))
		{
			Account a = store.get(mobileNo);
			a.setBalance(a.getBalance()+amount);
			return a;
		}
		else
		{
			throw new MobileNoDoesNotExists("mobile no does not exists"); 
		}
	}

	@Override
	public Account createAccount(String name , String mobileNo ,  String accountType , double balance) {

			if(store.containsKey(mobileNo))
			{
				throw new CustomerAlreadyExists("customer with this mobile number already exists");
			}
			else
			{
				Account a = new Account(name, mobileNo, accountType, balance);
				store.put(mobileNo , a);
				return a;
			}
	}
	
	@Override
	public Account findAccountByMobileNo(String mobileNo)
	{
		Account a = store.get(mobileNo);
		if(a == null)
		{
			throw new AccountNotFoundException("account not found");
		}
		return a;
	}

}
