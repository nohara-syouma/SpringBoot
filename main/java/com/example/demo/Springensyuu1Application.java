package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Products;
import com.example.demo.service.ProductsService;

@SpringBootApplication //SpringBootプロジェクトの実行ファイルであることを示してる
public class Springensyuu1Application {
	
	
	public static void main(String[] args) {
        ConfigurableApplicationContext context =
            SpringApplication.run(Springensyuu1Application.class, args);//SpringBootの実行に必要な記述、引数をクラス名と同じ名前にする

        ProductsService ProductsService = context.getBean(ProductsService.class);
        List<Products> list = ProductsService.findAll();
        for (Products u : list) {
            System.out.println(u.getProductInfo());
        }
    }

}
