package customerDatabaseManager;

public class Customer {
	
	private int id;
	private String name_customer;
	private String address;
	
	public Customer() {}
	
	public Customer(String name) {
		this.name_customer = name;
	}


	public Customer(int id, String name_customer, String address) {
		super();
		this.id = id;
		this.name_customer = name_customer;
		this.address = address;
	}

	public String getName_customer() {
		return name_customer;
	}

	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name_customer=" + name_customer + ", address=" + address + "]";
	}
	
	

}
