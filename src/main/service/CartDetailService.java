package main.service;

import main.model.CartDetail;

public interface CartDetailService {

	public CartDetail getById(long cartid);
	
	public void saveOrUpdate(CartDetail cartDetail);
	
	public void delete(long cartid);
}
