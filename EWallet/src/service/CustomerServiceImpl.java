package service;

import java.util.Set;

import dao.ICustomerDao;
import entities.Customer;
import exceptions.IncorrectMobileNoException;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDao dao;
	public CustomerServiceImpl(ICustomerDao dao) {
		this.dao = dao;
	
	}
	
	@Override
	public void addCustomer(Customer c) {

		dao.addCustomer(c);
	}

	@Override
	public void transferAmount(Customer c1, Customer c2, double amount) {
	
		dao.transferAmount(c1, c2, amount);
	}
	
	
	
	@Override
	public Customer findCustomerByMobileNo(String mobileNo) {

		if(mobileNo == null || mobileNo.length()>10 || mobileNo.length()<10)
		{
			throw new IncorrectMobileNoException ("incorrect mobile number");
		}
		Customer c = dao.findCustomerByMobileNo(mobileNo);
		return c;
	}
	

	@Override
	public Set<Customer> allCustomers() {
		
		Set<Customer> customers = dao.allCustomers();
		return customers;
	}

}
