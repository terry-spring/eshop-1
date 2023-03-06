package main.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import main.model.Cart;
import main.model.CartDetail;
import main.model.CartForm;
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

//	@GetMapping("/add-to-cart/{productId}")
//	public String addToCart(@PathVariable long productId, Model model) {
//		
//		 long customerId = 1L;
//	        //商業邏輯
//	        Product product = productService.getById(productId);
//	        Cart cart = cartService.getByCustomerId(customerId);
//	        List<CartDetail> cartDetails = new ArrayList<>();
//	        CartDetail cartDetail = new CartDetail();
//	        
//		    Date currentDate = new Date();
//	        int totalPrice = quantity * BigDecimal.valueOf(100);
//	        
//	        int quantity = 2;
//	        cartDetail.setDiscount(BigDecimal.valueOf(0.9));
//	        //cartDetail.setCartId(4);
//	        //cartDetail.setCartDetailId(3);
//	        cartDetail.setProductId(productId);
//	        cartDetail.setQuantity(quantity);
//	        cartDetail.setUnitPrice(product.getProductPrice());
//	        cartDetail.setTotalPrice(BigDecimal.valueOf(100));
//	        cartDetails.add(cartDetail);
//
//	        if (cart == null) {
//	            cart = new Cart();
//	            cart.setCartDetail(cartDetails);
//	            cart.setCustomerId(1);
//		            cart.setCrateDate(currentDate);
//		            cart.setUpdateDate(currentDate);
//	            cartService.saveOrUpdate(cart);
//	        } else {
//	            for(CartDetail detail: cart.getCartDetail()) {
//	                if (productId == detail.getProductId()) {
//	                    cartDetail.setQuantity(quantity);
//	                    break;
//	                }
//	            }
//		            cart.setUpdateDate(currentDate);
//		        cartDetailService.saveOrUpdate(cartDetail);
//	        }
//		return "redirect:/show-cartdetail";
//	}
	
	@GetMapping("/show-cartdetail/{cartId}")
	public String showCartDetail(@PathVariable long cartId,@ModelAttribute CartForm cartForm, Model model) {
		
//		List<CartDetail> newsList = new ArrayList<>();
		CartDetail cartDetail = cartDetailService.getByCartId(cartId);
		Product product = productService.getById(cartDetail.getProductId());
//		String cartDetailJson = new Json().toJson(cartDetail);
//		Map<String, Object> productmap = new HashMap();
//		Map<String, Object> cartDetailmap = new HashMap();
		model.addAttribute("product",product);
		model.addAttribute("cartdetail",cartDetail);
//		productmap.put("product", product.getName());
//		cartDetailmap.put("cartDetail", cartDetail.getQuantity());
//		System.out.println(cartDetailmap);
//		System.out.println(productmap);
		return "cart";
	}

    @PostMapping("/cart-form")
    public String CartForm(@Valid @ModelAttribute CartForm cartForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "cart-Form";
        }
		long customerId = 1L;
	    Cart cart = cartService.getByCustomerId(customerId);
	    List<CartDetail> cartDetails = new ArrayList<>();
        CartDetail cartDetail = new CartDetail();
        
        Product product = productService.getById(cartForm.getProductId());

        cartDetail.setQuantity(cartForm.getQuantity());
        cartDetail.setUnitPrice(product.getProductPrice());
        cartDetail.setTotalPrice(product.getProductPrice().multiply(BigDecimal.valueOf(cartForm.getQuantity())));
        cartDetail.setDiscount(BigDecimal.valueOf(0.9));
        cartDetail.setProductId(cartForm.getProductId());
//        cartDetails.add(cartDetail);
        long cardId = 1;
        if (cart == null) {
        	cartDetails.add(cartDetail);
            cart = new Cart();
            cart.setCartDetail(cartDetails);
            cart.setCustomerId(1);
//	            cart.setCrateDate(currentDate);
//	            cart.setUpdateDate(currentDate);
            cartService.saveOrUpdate(cart);
        	cartDetail.setCartId(cardId);
	        cartDetailService.saveOrUpdate(cartDetail);
//            return "redirect:show-cartdetail/{cardId}";
        } else {
        	CartDetail userCart = cartDetailService.getById(cart.getCartId());
        	Product cartProduct = productService.getById(userCart.getCartId());
        	int cartFormQuantity = cartForm.getQuantity();
                if (cartProduct.getProductId() == product.getProductId()) {
                    cartDetail.setQuantity(cartFormQuantity += cartDetail.getQuantity());
        	        cartDetailService.saveOrUpdate(cartDetail);
                }
//	            cart.setUpdateDate(currentDate);
        }
        return "redirect:show-cartdetail/"+cardId;
    }  
}