//package main.service;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import main.dao.CustmerDAO;
//import main.model.Customer;
//
//
//
//@Service
//@Transactional
//public class CustomerServiceImpl implements CustomerService{
//
//	@Autowired
//	private CustmerDAO custmerDAO;
//	
//	@Override
//	public List<Customer> getAll() {
//		return custmerDAO.getAll();
//	}
//
//	@Override
//	public Customer getById(long id) {
//		return custmerDAO.getById(id);
//	}
//
//	@Override
//	public void saveOrUpdate(Customer customer) {
//		custmerDAO.saveOrUpdate(customer);
//	}
//
//	@Override
//	public void delete(long id) {
//		custmerDAO.delete(id);
//	}
//	
//}
