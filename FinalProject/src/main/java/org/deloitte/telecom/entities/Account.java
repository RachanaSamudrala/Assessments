package com.deloitte.telcom.entity;

public class Account {

	private String name;
	private String mobileNo;
	private String accountType;
	private double balance;
	
	public Account()
	{
		
	}

	public Account(String name, String mobileNo, String accountType, double balance) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.accountType = accountType;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String toString()
	{
		String display = "name : "+name+" mobile number : "+mobileNo+" account type : "+accountType+" balance : "+balance;
		return display;
	}
	
	public int hashCode()
	{
		return mobileNo.hashCode();
	}
	
	public boolean equals(Object obj) {
		if(this == obj)
		{
			return true;
		}
		if(obj==null || !(obj instanceof Account))
		{
			return false;
		}
		
		Account a = (Account)obj;
		return a.mobileNo.equals(this.mobileNo);
		
		
	}
	
}	
