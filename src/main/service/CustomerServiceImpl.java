package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Customer;
import main.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getById(long CustomerId) {
		return customerRepository.getOne(CustomerId);
	}

	@Override
	public void saveOrUpdate(Customer Customer) {
		customerRepository.saveAndFlush(Customer);
	}

	@Override
	public void delete(long CustomerId) {
		customerRepository.deleteById(CustomerId);
	}
	
//	@Override
//	public void addUserToCustomer(long customerId, long userId) {
//		Customer customer = getById(id);
//		if(customer.ge() == null) {
//			tour.setUsers(new ArrayList<>());
//		}
//		User user = userRepository.getOne(userId);
//		if(user != null) {
//			tour.getUsers().add(user);
//			saveOrUpdate(tour);
//		}
//	}
}
