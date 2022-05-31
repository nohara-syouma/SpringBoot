package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Enitity.Product;
import com.example.dao.ProductDao;
import com.example.util.ParamUtil;

@Repository
public class PgProductDao implements ProductDao {

	//private static final String SELECT_NAME_PRICE = "SELECT * FROM products WHERE product_name = :product_name AND price = :price ORDER BY product_id";
	
	private static final String SELECT = "SELECT * FROM products WHERE ";
	
	private static final String ORDER_BY = " ORDER BY product_id";
	
	private static final String SQL_INSERT = "INSERT INTO products (product_name, price) VALUES (:product_name, :price)";
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Product> findAll() {
		return jdbcTemplate.query("SELECT * FROM products ORDER BY product_id",
				new BeanPropertyRowMapper<Product>(Product.class));
	}

	public List<Product> find(Product product) {
		
		// 「product_name = ?」、「price = ?」などの文字列が入る
        ArrayList<String> conditionList = new ArrayList<>();
               
        // 各検索条件の入力値用
        String productName = null;
        Integer productprice = null;
        
        if (product != null) {
            productName = product.getProductName();
            productprice = product.getPrice();
            
            System.out.println(productName);
            System.out.println(productprice);
        }
        
     // 各検索条件が全て未入力の場合、全件検索
        if (ParamUtil.isNullOrEmpty(productName) && productprice == null) {
            return findAll();
        }
        
        MapSqlParameterSource param = new MapSqlParameterSource();
	
        if (!ParamUtil.isNullOrEmpty(productName)) {
            conditionList.add("product_name = :product_name"); // WHERE句の条件に使用する文字列
            param.addValue("product_name",productName); // プレースホルダーに埋め込む値
        }
        
        if (productprice != null) {
            conditionList.add("price = :price"); // WHERE句の条件に使用する文字列
            param.addValue("price",productprice); // プレースホルダーに埋め込む値
        }
        
        String whereString = String.join(" AND ", conditionList.toArray(new String[] {}));
      
		String sql = SELECT + whereString + ORDER_BY;
		
		List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
		
		return resultList.isEmpty() ? null : resultList;
	}
	
	
	public int register(Product product) {
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("product_name",product.getProductName());
		param.addValue("price",product.getPrice());
		
		String sql = SQL_INSERT;
		
		
		
		return jdbcTemplate.update(sql, param);
	}

}
