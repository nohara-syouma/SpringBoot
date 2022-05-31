package com.example.service;

import java.util.List;

import com.example.Enitity.Product;

public interface ProductService {

	public List<Product> find(Product product);
	
	public int register(Product product);

}
