package main.dao;

import java.util.List;

import main.model.CartDetail;

public interface CartDetailDAO {

	public List<CartDetail> getAll();
	
	public CartDetail getById(long cartid);
	
	public void saveOrUpdate(CartDetail cartDetail);
	
	public void delete(long cartid);
}
