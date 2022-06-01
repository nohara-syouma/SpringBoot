package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Enitity.Product;
import com.example.dao.ProductDao;
import com.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
    private ProductDao productDao;
	
	@Override
    public List<Product> find(Product product) {
        return productDao.find(product);
    }
	
	@Override
    public int register(Product product) {
        return productDao.register(product);
    }
}
