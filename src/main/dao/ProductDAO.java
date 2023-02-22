package main.dao;

import java.util.List;

import main.model.Product;

public interface ProductDAO {

	public List<Product> getAll();
	
	public Product getById(long productId);
	
	public void saveOrUpdate(Product product);
	
	public void delete(long productId);
	
}