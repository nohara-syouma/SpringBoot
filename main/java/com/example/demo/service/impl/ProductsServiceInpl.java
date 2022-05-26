package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductsDao;
import com.example.demo.entity.Products;
import com.example.demo.service.ProductsService;


	
	@Service
	public class ProductsServiceInpl implements ProductsService {
	    @Autowired
	    private ProductsDao ProductsDao;

	    public List<Products> findAll() {
	        return ProductsDao.findAll();
	    }

}
