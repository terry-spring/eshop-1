package main.controller;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.ui.Model;
=======
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> origin/richard
import org.springframework.web.bind.annotation.RequestMapping;

import main.model.Tour;

@Controller
public class HomeController {
	@RequestMapping("/")
<<<<<<< HEAD
	public String getHome(Model model) {
		model.addAttribute("tour",new Tour());
		return "index";
		
/*	public String getHome() {
		Order order = new Order();
        OrderDetail orderDetail = new OrderDetail();
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetail.setDiscount(BigDecimal.valueOf(1));
         orderDetail.setProductId(1);
        orderDetail.setQuantity(12);
        orderDetail.setUnitPrice(BigDecimal.valueOf(123));
        orderDetails.add(orderDetail);

        orderDetail = new OrderDetail();
        orderDetail.setDiscount(BigDecimal.valueOf(2));
          orderDetail.setProductId(4);
        orderDetail.setQuantity(152);
        orderDetail.setUnitPrice(BigDecimal.valueOf(1213));
        orderDetails.add(orderDetail);

        order.setCustomerId(1);
        order.setEmployeeId(1);
        order.setOrderDetail(orderDetails);
        order.setOrderDate(new Date());
        order.setShippingMethodId(1);
        
       
        orderService.saveOrUpdate(order);
		List<Order> data = orderService.getAll();
//        orderService.delete(1);
        
		return "home";*/
=======
	public String getHome() {
		
		System.out.println("Password admin"+ PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"));
		System.out.println("Password employee"+ PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("employee"));
		System.out.println("Password client"+ PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("client"));
		return "index";
>>>>>>> origin/richard
	}
}
