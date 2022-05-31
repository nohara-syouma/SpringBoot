package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Enitity.Product;
import com.example.controller.form.TopForm;
import com.example.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping({ "/", "/top" })
	public String top(@ModelAttribute("top") TopForm form, Model model) {
		System.out.println("通った1");
		
		return "top";

	}

	@RequestMapping(value = "/searchResult",params = "search", method = RequestMethod.POST)
	public String searchResult(@ModelAttribute("top") TopForm form, Model model) {
		
		//form.setProductId(null);
		
		 Product products = new Product(null,form.getName(),form.getPrice());
		 System.out.println(products);

		List<Product> product = productService.find(products);
		
		System.out.println(product);

		if (product.isEmpty()) {
			model.addAttribute("msg", "対象のデータはありません。");
			return "top";

		} else {
			model.addAttribute("productList", product);
			return "searchResult";
		}

	}
	
	@RequestMapping(value = "/searchResult",params = "insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("top") TopForm form, Model model) {
		
		 Product products = new Product(null,form.getName(),form.getPrice());
		 
		 productService.register(products);
		 
		 return "insert";

	

	}

}
