package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.model.Service;
import com.poly.service.ServiceService;

@Controller
@RequestMapping("/homeuser")
public class ServiceController {
	
	@Autowired
	ServiceService service;
     @GetMapping("/service")
	public String getDichvu(Model model) {
    	 List<Service> list = service.findAll();
    	 model.addAttribute("service",list);
    	 System.out.println(list);
		return "user/dichvu1";
	}
     @GetMapping("/foot")
     public String getbill(Model model) {
    	
		return "user/bill";
	}
	
	
}
