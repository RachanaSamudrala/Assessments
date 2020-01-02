package com.deloitte.telcom.ui;

import java.util.Scanner;

import com.deloitte.telcom.dao.AccountDaoImpl;
import com.deloitte.telcom.entity.Account;
import com.deloitte.telcom.service.AccountServiceImpl;
import com.deloitte.telcom.service.IAccountService;

public class AccountUi {

	IAccountService service = new AccountServiceImpl(new AccountDaoImpl());
	
	String name;
	String mobileNo;
	String accountType;
	double balance;
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		AccountUi main = new AccountUi();
		main.execute();
	}
	
	void execute()
	{
		String ch;
		
			System.out.println("Welcome to Mobile Service Customer Care");
			System.out.println("***************************************");
			System.out.println("Menu : \n 1. Account balance enquiry \n 2. Recharge account \n 3. Create account \n 4. Exit");
			System.out.println("\n please enter a option");
			while(true)
			{	
			int option = sc.nextInt();
			
			if(option == 1)
			{
				accountBalanceEnquiry();
			}
			else if(option == 2)
			{
				rechargeAccount();
			}
			else if(option == 3)
			{
				createAccount();
			}
			else if(option == 4)
			{
				System.out.println("do you want to exit? \n press z to exit");
				ch = sc.next();
				if(ch.equals("z"))
					break;
			}
			else
			{
				System.out.println("wrong option");
			}
		}
		
	}
	
	void accountBalanceEnquiry()
	{
		System.out.println("enter mobile number : ");
		mobileNo = sc.next();
		Account a = service.accountBalanceEnquiry(mobileNo);
		System.out.println("Balance : "+a.getBalance());
		
	}
	
	void rechargeAccount()
	{
		double amount;
		System.out.println("enter mobile number : ");
		mobileNo = sc.next();
		System.out.println("enter recharge amount");
		amount = sc.nextDouble();
		Account a = service.rechargeAccount(mobileNo, amount);
		System.out.println("account recharged with amount"+amount);
		System.out.println("new balance : "+a.getBalance());
		System.out.println("details are : ");
		print(a);
	}
	
	void createAccount()
	{
		System.out.println("Enter the details : ");
		System.out.println("Enter name : ");
		name = sc.next();
		System.out.println("Enter mobile number : ");
		mobileNo = sc.next();
		System.out.println("Enter account type");
		accountType = sc.next();
		System.out.println("Enter balance : ");
		balance = sc.nextDouble();
		
		Account a = service.createAccount(name, mobileNo, accountType, balance);
		System.out.println("account created");
		print(a);
	}
	
	void print(Account a)
	{
		System.out.println("Name : "+name+" Mobile Number : "+mobileNo+ " Account type : "+accountType+" balance : "+balance);
	}
}
