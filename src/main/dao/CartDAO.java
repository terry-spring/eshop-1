package main.dao;

import java.util.List;

import main.model.Cart;

public interface CartDAO {
	
	public List<Cart> getAll();
	
	public Cart getById(long cartid);
	
	public void saveOrUpdate(Cart cart);
	
	public void delete(long cartid);
	
}
