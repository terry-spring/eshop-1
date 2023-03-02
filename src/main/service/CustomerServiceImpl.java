package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Customer;
import main.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAll() {
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

//	@Override
//	public void addUserToCustomer(long id, long userId) {
//		 TODO Auto-generated method stub
		
//	}

}
