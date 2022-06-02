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
public class PgProductDao implements ProductDao {
	
	private static final String DELETE = "DELETE FROM products WHERE product_id = :product_id";
	
	private static final String UPDATE = "UPDATE products SET product_name = :product_name, price = :price WHERE product_id = :product_id";
	
	private static final String SELECT_BY_USER_ID = "SELECT * FROM products WHERE product_id = :product_id ORDER BY product_id";
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	
	public int delete(Product product) {
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("product_id",product.getProductId());
		
		String sql = DELETE;
		
		return jdbcTemplate.update(sql, param);
		
	}
	
	public int update(Product product) {
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("product_id",product.getProductId());
		param.addValue("product_name",product.getProductName());
		param.addValue("price",product.getPrice());
		
		String sql = UPDATE;
		
		return jdbcTemplate.update(sql, param);
		
		
	}
	
	public Product findById(Integer id) {
        String sql = SELECT_BY_USER_ID;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("product_id", id);

        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }

}
