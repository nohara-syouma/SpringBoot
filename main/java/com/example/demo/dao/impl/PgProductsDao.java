package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ProductsDao;
import com.example.demo.entity.Products;

	
@Repository
public class PgProductsDao implements ProductsDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Products> findAll() {
        return jdbcTemplate.query("SELECT * FROM Products ORDER BY product_id",
            new BeanPropertyRowMapper<Products>(Products.class));
    }
}
