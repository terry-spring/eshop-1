package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Customer;
import main.model.User;
import main.repository.CustomerRepository;
import main.repository.UserRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getById(long customerId) {
	    return	customerRepository.findById(customerId).orElse(null);
	}

	@Override
	public void saveOrUpdate(Customer customer) {
		customerRepository.saveAndFlush(customer);
	}

	@Override
	public void delete(long customerId) {
		customerRepository.deleteById(customerId);
	}

	@Override
	public void addUserToCustomer(long customerId, String login) {
		Customer customer =getById(customerId);
		if(customer.getUser() !=null) {
			User user = userRepository.findByLogin(login);
			customer.setUser(user);
			customerRepository.save(customer);
		}
	}
	
}
