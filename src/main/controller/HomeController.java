package main.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.model.Order;
import main.model.OrderDetail;
import main.service.OrderService;

@Controller
public class HomeController {
    @Autowired
    private OrderService orderService;
	@RequestMapping("/")
	public String getHome() {
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
        
		return "home";
	}
	
}
