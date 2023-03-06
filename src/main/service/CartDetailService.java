package main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.model.Cart;
import main.model.CartDetail;

@Service
public interface CartDetailService {

	public List<CartDetail> getAll();

	public CartDetail getById(long cartId);
	
	public void saveOrUpdate(CartDetail cartDetail);
	
	public void delete(long cardId);
	
	public CartDetail getByCartId(long cartId);
}
