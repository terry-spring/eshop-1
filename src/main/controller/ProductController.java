package main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.model.Product;
import main.model.Tour;
import main.model.TourDetails;
import main.service.ProductService;

@Controller
//@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/add-product")
	public String showForm(Model model) {
		model.addAttribute("product", new Product());
		return "product-form";
	}
	
	@PostMapping("/process-product-form")
	public String showProductData(@Valid @ModelAttribute Product product, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "product-form";
		}
		productService.saveOrUpdate(product);
		return "redirect:show-product-offer";
	}
	
	@GetMapping("/show-product-offer")
	public String getProducts(Model model) {
		List<Product> products = productService.getAll();
		model.addAttribute("products", products);
		return "products";
	}
	
	@GetMapping("/delete-product/{productId}")
	public String deleteProducts(@PathVariable long productId) {
		Product product = productService.getById(productId);
		if(product != null) {
			productService.delete(productId);
		}
		return "redirect:/show-product-offer";
	}
	
	@GetMapping("/edit-product/{productId}")
	public String editProducts(@PathVariable long productId, Model model) {
		Product product = productService.getById(productId);
		if(product != null) {
			model.addAttribute("product", product);
			return "product-form";
		}
		return "redirect:/show-product-offer";
	}
}
