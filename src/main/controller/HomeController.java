package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import main.model.Product;
import main.service.ProductService;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
  @RequestMapping("/")
	public String getHome(Model model) {
    	List<Product>products = productService.getAll();
    	model.addAttribute("products", products);

		
	        return "index";
		
		}
	}
	

