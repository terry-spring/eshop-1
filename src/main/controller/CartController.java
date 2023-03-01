package main.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import main.model.Cart;
import main.model.CartDetail;
import main.model.Product;
import main.service.CartDetailService;
import main.service.CartService;
import main.service.ProductService;

@Controller
public class CartController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;	
	@Autowired
	private CartDetailService cartDetailService;


	@GetMapping("/add-to-cart/{productId}")
	public String addToCart(@PathVariable long productId, Model model) {
		
		 long customerId = 1L;
	        //商業邏輯
	        Product product = productService.getById(productId);
	        Cart cart = cartService.getByCustomerId(customerId);
	        List<CartDetail> cartDetails = new ArrayList<>();
	        CartDetail cartDetail = new CartDetail();
//		        Date currentDate = new Date();
	        int quantity = 2;
//	        int totalPrice = quantity * BigDecimal.valueOf(100);
	        cartDetail.setDiscount(BigDecimal.valueOf(0.9));
	        cartDetail.setCartId(4);
	        cartDetail.setProductId(productId);
//	        cartDetail.setQuantity(quantity);
	        cartDetail.setUnitPrice(product.getProductPrice());
	        cartDetail.setTotalPrice(BigDecimal.valueOf(100));
	        cartDetails.add(cartDetail);

	        if (cart == null) {
	            cart = new Cart();
	            cart.setCartDetail(cartDetails);
	            cart.setCustomerId(1);
//		            cart.setCrateDate(currentDate);
//		            cart.setUpdateDate(currentDate);
	            cartService.saveOrUpdate(cart);
	        } else {
	            for(CartDetail detail: cart.getCartDetail()) {
	                if (productId == detail.getProductId()) {
	                    cartDetail.setQuantity(quantity);
	                    break;
	                }
	            }
//		            cart.setUpdateDate(currentDate);
//		            carDetailService.saveOrUpdate(cartDetail);
	        }
		return "redirect:/show-cartDetail";
	}
	
	@GetMapping("/show-cartDetail")
	public String getCart(Model model) {
		List<Product> products = productService.getAll();
		List<CartDetail> cartDetail= cartDetailService.getAll();
		model.addAttribute("products", products);
		model.addAttribute("cartDetail", cartDetail);
		return "cart";
	}
}