package main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.OrderDetailDAO;
import main.model.OrderDetail;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Override
	public OrderDetail getById(long id) {
		return orderDetailDAO.getById(id);
	}

	@Override
	public void saveOrUpdate(OrderDetail orderDetails) {
		orderDetailDAO.saveOrUpdate(orderDetails);
	}

	@Override
	public void delete(long id) {
		orderDetailDAO.delete(id);
	}

}
