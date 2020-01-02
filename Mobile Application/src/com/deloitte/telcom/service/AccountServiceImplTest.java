package com.deloitte.telcom.service;

import org.junit.Test;

import com.deloitte.telcom.dao.AccountDaoImpl;
import com.deloitte.telcom.dao.IAccountdao;
import com.deloitte.telcom.entity.Account;
import com.deloitte.telcom.exceptions.IncorrectMobileNoException;

import java.util.Map;

import org.junit.*;

public class AccountServiceImplTest {

	@Test
	
	public void testCreateAccount_1()
	{
		AccountServiceImpl service= new AccountServiceImpl(new AccountDaoImpl());
		String name = "abc";
		String mobileNo = "1234567890";
		String accountType = "prepaid";
		double balance = 1000;
		
		Account account = service.createAccount(name , mobileNo , accountType , balance);
		Assert.assertNotNull(account);
		
		Assert.assertEquals(balance, account.getBalance() , 0);
		Assert.assertEquals(name, account.getName());
		
		Map<String , Account> store = service.getDao().getStore();
		Account expected = store.get(mobileNo);
		Assert.assertEquals(expected , account);
	}
	
 @Test(expected=IncorrectMobileNoException.class)
	
	public void testCreateAccount_2()
	{
		AccountServiceImpl service= new AccountServiceImpl(new AccountDaoImpl());
		String name = "abc";
		String mobileNo = null;
		String accountType = "prepaid";
		double balance = 1000;
		Account account = service.createAccount(name, mobileNo, accountType, balance);
	}


@Test

	public void testFindByMobileNo_1()
	{
		AccountServiceImpl service = new AccountServiceImpl(new AccountDaoImpl());
		String name = "def";
		String mobileNo = "1234567890";
		String accountType = "prepaid";
		double balance = 500;
		Account account = service.createAccount(name, mobileNo, accountType, balance);
		Map<String , Account> store = service.getDao().getStore();
		store.put(mobileNo, account);
		Assert.assertNotNull(account);
		Account fetched = service.findAccountByMobileNo(mobileNo);
		Assert.assertEquals(fetched, account);
	}
}