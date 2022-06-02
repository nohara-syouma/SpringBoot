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
import com.example.controller.form.DeleteForm;
import com.example.service.ProductService;

@Controller
public class DeleteController {

	@Autowired
	ProductService productService;
	
	@Autowired
    MessageSource messageSource;

	@RequestMapping("/delete" )
	public String top(@ModelAttribute("delete") DeleteForm form, Model model) {
		System.out.println("通った1");
		
		return "delete";

	}

	@RequestMapping(value = "/delete",params = "delete", method = RequestMethod.POST)
	public String insert(@Validated @ModelAttribute("delete") DeleteForm form, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			
			
            return "delete";
        }
		
		 Product products = new Product(form.getProductId(),form.getName(),form.getPrice());
		 int product = productService.delete(products);
		 
		 if (product == 0) {
				String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
	            model.addAttribute("msg", errMsg);
				
				return "delete";

			}else{
		 
		 
		 
		 	return "deleteResult";
		 
			}
		}
	
	}
