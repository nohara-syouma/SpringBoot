package com.example.service.impl;

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
    public Product findById(Integer id) {
        return productDao.findById(id);
    }
}
