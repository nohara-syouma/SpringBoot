package com.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Enitity.Product;
import com.example.dao.ProductDao;

@Repository
public class PgProductDao implements ProductDao{
	
//	@Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public List<Product> findAll() {
//        return jdbcTemplate.query("SELECT * FROM products ORDER BY product_id", new BeanPropertyRowMapper<Product>(Product.class));
//    }
	
	private static final String SELECT_BY_USER_ID = "SELECT * FROM products WHERE product_id = :product_id ORDER BY product_id";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Product findById(Integer id) {
        String sql = SELECT_BY_USER_ID;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("product_id", id);

        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }

}
