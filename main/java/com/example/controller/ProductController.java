package com.example.controller;

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
		return "top";
	}

	@RequestMapping(value = "/searchResult", method = RequestMethod.POST)
	public String searchResult(@ModelAttribute("top") TopForm form, Model model) {

		Product product = productService.findById(form.getId());
		
		if(product == null) {
			model.addAttribute("productList", "対象のデータはありません");
			return "top";
		}

		model.addAttribute("productList", product);
		
		return "searchResult";
	}

}
