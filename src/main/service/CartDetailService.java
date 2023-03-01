package main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.model.CartDetail;

@Service
public interface CartDetailService {

	public List<CartDetail> getAll();

	public CartDetail getById(long cartid);
	
	public void saveOrUpdate(CartDetail cartDetail);
	
	public void delete(long cartid);
}
