package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import main.model.Cart;
import main.model.Product;
import main.service.ProductService;

public class CartController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/add-to-cart/{productId}")
	public String showForm(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("cart", new Cart());
		return "product-form";
	}
}
