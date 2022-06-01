package com.example.dao;

import java.util.List;

import com.example.Enitity.Product;

public interface ProductDao {
	
	public List<Product> find(Product product);
	
	public int register(Product product);

}
