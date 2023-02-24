package main.service;

import java.util.List;

import main.model.Customer;


public interface CustomerService {

	public List<Customer> getAll();
	
	public Customer getById(long cusetomerId);
	
	public void saveOrUpdate(Customer customer);
	
	public void delete(long customerId);
	
//	public void addUserToCustomer(long id ,long userId);
}
