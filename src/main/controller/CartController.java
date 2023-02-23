package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import main.model.Cart;
import main.model.Product;
import main.service.ProductService;

public class CartController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/add-to-cart/{productId}")
	public String addToCart(@PathVariable long productId, Model model) {
		Product product = productService.getById(productId);
		if(product != null) {
			model.addAttribute("product", product);
			model.addAttribute("cart", new Cart());
			return "product-form";
		}
		return "redirect:/show-product-offer";
	}
}
