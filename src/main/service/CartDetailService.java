package main.service;

import java.util.List;

import main.model.CartDetail;

public interface CartDetailService {

	public List<CartDetail> getAll();

	public CartDetail getById(long cartid);
	
	public void saveOrUpdate(CartDetail cartDetail);
	
	public void delete(long cartid);
}
