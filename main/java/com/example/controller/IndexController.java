package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Entity.Prodct;
import com.example.controller.form.IndexForm;
import com.example.util.ParamUtil;

@Controller
public class IndexController {

    
    @RequestMapping("/index")
    public String index(@ModelAttribute("index") IndexForm form, Model model) {
    	List<Prodct> userList = new ArrayList<>();
        userList.add(new Prodct(101, "鉛筆", 50));
        userList.add(new Prodct(102, "消しゴム", 100));

        // プルダウンの内容をmodelにセット
        model.addAttribute("userList", userList);
        return "index";
    }
    
 
    

    
    @RequestMapping(value = "/result", params = "param1", method = RequestMethod.POST)
    public String result1(@ModelAttribute("index") IndexForm form, Model model) {
    	
    	int id = form.getId();
    	
    	Prodct user = null;
        switch (id) {
        case 101:
            user = new Prodct(101, "鉛筆", 50);
            break;
        case 102:
            user = new Prodct(102, "消しゴム", 100);
            break;
        }
        
        model.addAttribute("user", user);
    	
        model.addAttribute("msg", form.getInput());
        //model.addAttribute("msg1", form.getId());
        return "result1";
    }
    
 
    @RequestMapping("/index2")
    public String index2(@ModelAttribute("index2") IndexForm form, Model model) {
    	
        return "index2";
    }
    
    @RequestMapping("/login")
    public String login(@ModelAttribute("login") IndexForm form, Model model) {
    	
        return "login";
    }
    
    
    
    @RequestMapping(value = "/result", params = "param2", method = RequestMethod.POST)
    public String result2(@ModelAttribute("index2") IndexForm form, Model model) {
    	
    	String logid = form.getLogid();
    	String pass = form.getPass();
    	if (ParamUtil.isNullOrEmpty(logid) && ParamUtil.isNullOrEmpty(pass)) {
			
			return "login";
		}else if(logid.equals("axiz") && pass.equals("axizuser")) {
			 return "menu";
		}
    	
    	
        return "menu";
        
    }

 

}
