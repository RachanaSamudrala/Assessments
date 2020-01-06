package ui;

import java.util.Collection;
import java.util.Set;

import dao.CustomerDaoImpl;
import entities.Customer;
import exceptions.CustomerNotFoundException;
import exceptions.IncorrectMobileNoException;
import service.CustomerServiceImpl;
import service.ICustomerService;

public class CustomerUi {

	private ICustomerService service  = new CustomerServiceImpl(new CustomerDaoImpl());
			
	public static void main(String[] args) {		
		
			CustomerUi ui = new CustomerUi();
			ui.execute();
	}
	
	public void execute()
	{
		try {
			
			Customer c1 = new Customer("abc", "9999911111", 1000);
			Customer c2 = new Customer("def", "9999922222", 2000);
			Customer c3 = new Customer("ghi", "9999933333", 3000);
			
			service.addCustomer(c1);
			service.addCustomer(c2);
			service.addCustomer(c3);
			
			Customer fetched1 = service.findCustomerByMobileNo("9999911111");
			Customer fetched2 = service.findCustomerByMobileNo("9999933333");
			
			System.out.println(fetched1);
			System.out.println(fetched2);
			
			System.out.println("***** printing all customers *****");
			Set<Customer> customers = service.allCustomers();
			print(customers);
			
			service.transferAmount(c1 , c2 , 500);
			System.out.println("***** after transfer *****");
			print(customers);
			
		}
		catch(CustomerNotFoundException e) {
			System.out.println("Customer not found");
		}
		catch(IncorrectMobileNoException e) {
			System.out.println("incorrect mobile number");
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
		
	}
	
	void print(Collection<Customer> customers)
	{
		for(Customer c : customers)
		{
			System.out.println(c.getName()+" "+c.getMobileNo()+" "+c.getBalance());
		}
	}
}


