package main.dao;

import main.model.CartDetail;

public interface CartDetailDAO {

	public CartDetail getById(long cartid);
	
	public void saveOrUpdate(CartDetail cartDetail);
	
	public void delete(long cartid);
}
