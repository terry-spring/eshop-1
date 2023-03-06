package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import main.model.OrderDetail;
import main.repository.OrderDetailRepository;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Override
	public OrderDetail getById(long id) {
		return orderDetailRepository.getOne(id);
	}

	@Override
	public void saveOrUpdate(OrderDetail orderDetails) {
		orderDetailRepository.save(orderDetails);
	}

	@Override
	public void delete(long id) {
		orderDetailRepository.deleteById(id);
	}
	 @Override
	    public List<OrderDetail> getByOrderId(long orderId) {
	        return orderDetailRepository.getByOrderId(orderId);
	    }

}
