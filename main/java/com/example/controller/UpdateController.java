package com.example.controller;

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
import com.example.controller.form.UpdateForm;
import com.example.service.ProductService;

@Controller
public class UpdateController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
    MessageSource messageSource;
	
	@RequestMapping("/update" )
	public String update(@ModelAttribute("update") UpdateForm form, Model model) {
		System.out.println("通った1");
		
		return "update";

	}
	
	@RequestMapping(value = "/update",params = "update", method = RequestMethod.POST)
	public String updateResult(@Validated @ModelAttribute("update") UpdateForm form, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			
			
            return "update";
        }
		
		 Product searchproduct = productService.findById(form.getProductId());
		
		 Product products = new Product(form.getProductId(),form.getName(),form.getPrice());
		 int product = productService.update(products);
		 
		 
		 
		 if (product == 0) {
				String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
	            model.addAttribute("msg", errMsg);
				
				return "update";

			}else{
				
				
				
				model.addAttribute("productList", searchproduct);
				
				model.addAttribute("product", products);
		 
		 	return "updateResult";
		 
			}
		}
	
}
