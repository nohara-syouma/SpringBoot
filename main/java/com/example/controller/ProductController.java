package com.example.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	
	@Autowired
    MessageSource messageSource;

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

		if (product == null) {
			String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
            model.addAttribute("msg", errMsg);
			
			return "top";

		} else {
			model.addAttribute("productList", product);
			return "searchResult";
		}

	}
	
	@RequestMapping(value = "/searchResult",params = "insert", method = RequestMethod.POST)
	public String insert(@Validated @ModelAttribute("top") TopForm form, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			
			
            return "top";
        }
		
		 Product products = new Product(null,form.getName(),form.getPrice());
		 
		 productService.register(products);
		 
		 return "insert";

	

	}

}
