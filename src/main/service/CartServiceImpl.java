package main.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Cart;
import main.model.CartDetail;
import main.model.Product;
import main.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService{

	@Autowired
	private ProductService productService;
	@Autowired
	private CartRepository cartRepository;
		
	@Override
	public List<Cart> getAll() {
		return cartRepository.findAll();
	}

	@Override
	public Cart getById(long cartId) {
		return cartRepository.findById(cartId).orElse(null);
	}

	@Override
	public void saveOrUpdate(Cart cart) {
		cartRepository.save(cart);
	}

	@Override
	public void delete(long cartId) {
		cartRepository.deleteById(cartId);
	}

	@Override
	public Cart getByCustomerId(long customerId) {
		return cartRepository.findById(customerId).orElse(null);
	}

	@Override
	public void addProduct2cart(long productId, int quantity) {
		 long customerId = 1L;
        //商業邏輯
        Product product = productService.getById(productId);
        Cart cart = getByCustomerId(customerId);
        List<CartDetail> cartDetails = new ArrayList<>();
        CartDetail cartDetail = new CartDetail();
//	        Date currentDate = new Date();

        cartDetail.setDiscount(BigDecimal.valueOf(0.9));
        cartDetail.setProductId(productId);
        cartDetail.setQuantity(quantity);
        cartDetail.setUnitPrice(product.getProductPrice());
        cartDetails.add(cartDetail);

        if (cart == null) {
            cart = new Cart();
            cart.setCartDetail(cartDetails);
            cart.setCustomerId(1);
//	            cart.setCrateDate(currentDate);
//	            cart.setUpdateDate(currentDate);
            saveOrUpdate(cart);
        } else {
            for(CartDetail detail: cart.getCartDetail()) {
                if (productId == detail.getProductId()) {
                    cartDetail.setQuantity(quantity);
                    break;
                }
            }
//	            cart.setUpdateDate(currentDate);
//	            carDetailService.saveOrUpdate(cartDetail);
        }
	}
}
