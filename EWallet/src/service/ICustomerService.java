package service;

import java.util.Set;

import entities.Customer;

public interface ICustomerService {

	void addCustomer(Customer c);
	
	public void transferAmount(Customer c1 , Customer c2 , double amount);
	
	
	Customer findCustomerByMobileNo(String mobileNo);
	
	Set<Customer> allCustomers();
	
}
