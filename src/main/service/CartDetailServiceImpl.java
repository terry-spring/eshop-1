package main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.CartDetailDAO;
import main.model.CartDetail;

@Service
@Transactional
public class CartDetailServiceImpl implements CartDetailService{

	@Autowired
	private CartDetailDAO cartDetailDAO;

	@Override
	public void delete(long cartid) {
		cartDetailDAO.delete(cartid);
	}

	@Override
	public CartDetail getById(long cartid) {
		return cartDetailDAO.getById(cartid);
	}

	@Override
	public void saveOrUpdate(CartDetail cartDetail) {
		cartDetailDAO.saveOrUpdate(cartDetail);
	}

}
