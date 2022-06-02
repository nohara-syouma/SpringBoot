package com.example.dao;

import com.example.Enitity.Product;

public interface ProductDao {
	

	public int delete(Product product);
	
	public int update(Product product);
	
	public Product findById(Integer id);

}
