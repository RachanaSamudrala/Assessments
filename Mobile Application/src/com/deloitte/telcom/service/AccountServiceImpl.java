package com.deloitte.telcom.service;

import com.deloitte.telcom.dao.IAccountdao;
import com.deloitte.telcom.entity.Account;
import com.deloitte.telcom.exceptions.IncorrectBalanceException;
import com.deloitte.telcom.exceptions.IncorrectMobileNoException;

public class AccountServiceImpl implements IAccountService {
	
	private IAccountdao dao;
	
	public IAccountdao getDao() {
		return dao;
	}

	public AccountServiceImpl(IAccountdao dao) 
	{
		this.dao = dao;
	}

	@Override
	public Account accountBalanceEnquiry(String mobileNo) {

		if(mobileNo == null || mobileNo.length()!=10)
		{
			throw new IncorrectMobileNoException("incorrect mobile number");
		}
		else
		{
			Account a = dao.accountBalanceEnquiry(mobileNo);
			return a;
		}
	}

	@Override
	public Account rechargeAccount(String mobileNo, double amount) {

		if(mobileNo == null || mobileNo.length()!=10)
		{
			throw new IncorrectMobileNoException("incorrect mobile number");
		}
		else
		{
			Account a =dao.rechargeAccount(mobileNo, amount);
			return a;
		}
	}

	@Override
	public Account createAccount(String name , String mobileNo , String accountType , double balance) {

		if(mobileNo == null || mobileNo.length()!=10 )
		{
			throw new IncorrectMobileNoException("incorrect mobile number");
		}
		else if(balance<0.0)
		{
			throw new IncorrectBalanceException("balance less than 0 not accepted");
		}
		else
		{
			Account a = dao.createAccount(name, mobileNo, accountType, balance);
			return a;
		}
	}
	
	public Account findAccountByMobileNo(String mobileNo)
	{
		if(mobileNo.length()!=10||mobileNo == null)
		{
			throw new IncorrectMobileNoException("incorrect mobile number");
		}
		Account a = dao.findAccountByMobileNo(mobileNo);
		return a;
	}

}
