package entities;

public class Customer {

	private String name;
	private String mobileNo;
	private double balance;

	public Customer() {

	}

	public Customer(String name, String mobileNo, double balance) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void transferAmount(Customer c, double amount) {
		if (balance > amount) {
			this.balance = balance - amount;
			c.balance = c.balance + amount;
			System.out.println("\nAmount transferred");
		} else {
			System.out.println(this.getName() + " has insufficient balance");
		}
	}

	@Override
	public String toString() {
		String display = name + " " + mobileNo + " " + balance;
		return display;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof Customer)) {
			return false;
		}
		Customer c = (Customer) obj;
		return c.mobileNo.equals(this.mobileNo);
	}

	@Override
	public int hashCode() {
		return mobileNo.hashCode();
	}
}
