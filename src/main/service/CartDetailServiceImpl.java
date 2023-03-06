package main.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Cart;
import main.model.CartDetail;
import main.repository.CartDetailRepository;

@Service
@Transactional
public class CartDetailServiceImpl implements CartDetailService{

	@Autowired
	private CartDetailRepository cartDetailRepository;
	
	@Override
	public List<CartDetail> getAll() {
		return cartDetailRepository.findAll();
	}

	@Override
	public void delete(long cartId) {
		cartDetailRepository.deleteById(cartId);
	}

	@Override
	public CartDetail getById(long cartId) {
		return cartDetailRepository.getOne(cartId);
	}

	@Override
	public void saveOrUpdate(CartDetail cartDetail) {
		cartDetailRepository.saveAndFlush(cartDetail);
	}

	@Override
	public CartDetail getByCartId(long cartId) {
		return cartDetailRepository.findById(cartId).orElse(null);
	}
	
}
