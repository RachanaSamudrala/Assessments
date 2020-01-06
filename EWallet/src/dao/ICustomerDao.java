package dao;

import java.util.Set;

import entities.Customer;

public interface ICustomerDao {

	void addCustomer (Customer c);
	
	Customer findCustomerByMobileNo (String mobileNo);
	
	public void transferAmount(Customer c1 , Customer c2 , double amount);
	
	Set<Customer> allCustomers();
	
}
