package main.service;

import java.util.List;

import main.model.Product;

public interface ProductService {

	public List<Product> getAll();
	
	public Product getById(int id);
	
	public void saveOrUpdate(Product product);
	
	public void delete(int id);
	
}
