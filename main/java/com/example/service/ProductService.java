package com.example.service;

import com.example.Enitity.Product;

public interface ProductService {

	
	public int delete(Product product);
	
	public int update(Product product);
	
	public Product findById(Integer id);

}
