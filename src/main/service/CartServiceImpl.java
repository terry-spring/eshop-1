package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.CartDAO;
import main.model.Cart;

@Service
@Transactional
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDAO cartDAO;
		
	@Override
	public List<Cart> getAll() {
		return cartDAO.getAll();
	}

	@Override
	public Cart getById(long cartId) {
		return cartDAO.getById(cartId);
	}

	@Override
	public void saveOrUpdate(Cart cart) {
		cartDAO.saveOrUpdate(cart);
	}

	@Override
	public void delete(long cartId) {
		cartDAO.delete(cartId);
	}

}
