package main.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@GetMapping("/show-cartdetail/{cartId}")
	public String showCartDetail(@PathVariable long cartId,@ModelAttribute CartForm cartForm, Model model) {
		
//		List<CartDetail> newsList = new ArrayList<>();
		
		CartDetail cartDetail = cartDetailService.getByCartId(cartId);
		Product product = productService.getById(cartDetail.getProductId());
		
//		Map<String, Object> productmap = new HashMap();
//		Map<String, Object> cartDetailmap = new HashMap();
		
		model.addAttribute("product",product);
		model.addAttribute("cartdetail",cartDetail);
		
//		productmap.put("product", product.getName());
//		cartDetailmap.put("cartDetail", cartDetail.getQuantity());
//		System.out.println(cartDetailmap);
//		System.out.println(productmap); 
		
//		Cart cart = cartService.getById(cartId);
//		ArrayList<Object> image = new ArrayList<>();
//		ArrayList<Object> brand = new ArrayList<>();
//		ArrayList<Object> name = new ArrayList<>();
//		ArrayList<Object> unitprice = new ArrayList<>();
//		ArrayList<Object> quantity = new ArrayList<>();
//		ArrayList<Object> totalprice = new ArrayList<>();
//		
//		System.out.println(cart);
//		System.out.println(cart.getCartDetail());
//		
//		for(CartDetail cartDetail : cartService.getById(cartId)) {
//			Product product = productService.getById(cartDetail.getProductId());
//			image.add(product.getProductImage());
//			brand.add(product.getBrand());
//			name.add(product.getName());
//			unitprice.add(cartDetail.getUnitPrice());
//			quantity.add(cartDetail.getQuantity());
//			totalprice.add(cartDetail.getTotalPrice());
//		}
//		
//        Map<String,ArrayList<Object>> shoppingcart = new HashMap<>();
//        shoppingcart.put("image",image);
//        shoppingcart.put("brand",brand);
//        shoppingcart.put("name",name);
//        shoppingcart.put("unitprice",unitprice);
//        shoppingcart.put("quantity",quantity);
//        shoppingcart.put("totalprice",totalprice);
		
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
//            cart.setCrateDate(currentDate);
//            cart.setUpdateDate(currentDate);
            cartService.saveOrUpdate(cart);
        	cartDetail.setCartId(cardId);
	        cartDetailService.saveOrUpdate(cartDetail);
//            return "redirect:show-cartdetail/{cardId}";
        } else {
        	CartDetail userCart = cartDetailService.getById(cart.getCartId());
        	int cartFormQuantity = cartForm.getQuantity();
                if (userCart.getProductId() == product.getProductId()) {
                	cartFormQuantity += userCart.getQuantity();
                	userCart.setQuantity(cartFormQuantity);
        	        cartDetailService.saveOrUpdate(userCart);
                }else {
                	long cartId = cart.getCartId();
                	cartDetail.setCartId(cardId);
//	            	cartDetails.add(cartDetail);
//	                cart.setCartDetail(cartDetails);
	    	        cartDetailService.saveOrUpdate(cartDetail);
	//	            cart.setUpdateDate(currentDate);
                }
        }
        return "redirect:show-cartdetail/" + cardId;
    }  
}