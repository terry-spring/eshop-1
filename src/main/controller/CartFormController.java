package main.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import main.model.Cart;
import main.model.CartDetail;
import main.model.CartForm;
import main.model.Product;
import main.service.CartDetailService;
import main.service.CartService;
import main.service.ProductService;

@Controller
public class CartFormController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;	
	@Autowired
	private CartDetailService cartDetailService;

	@GetMapping("/show-cartform/{productId}")
	public String showCartForm(@PathVariable long productId,@ModelAttribute CartForm cartForm, Model model) {

		Product product = productService.getById(productId);

		if (product != null) {
			
			//CartForm cartForm = new CartForm(); 
			cartForm.setName(product.getName());
			cartForm.setProductDescription(product.getProductDescription());
			cartForm.setProductImage(product.getProductImage());
			cartForm.setProductPrice(product.getProductPrice());
			model.addAttribute("cartForm", cartForm);
			return "cart-form";
	        }
		return "redirect:/add-to-cart/{productId}";
	}
}
