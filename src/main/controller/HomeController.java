package main.controller;

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
        order.setOrderId(1);
        OrderDetail orderDetail = new OrderDetail();
        List<OrderDetail> orders = new ArrayList<>();
        orderDetail.setDiscount(1);
        orderDetail.setOrderId(1);
        orderDetail.setProductId(1);
        orderDetail.setQuantity(12);
        orderDetail.setUnitPrice(123);
        orders.add(orderDetail);

        orders = new ArrayList<>();
        orderDetail.setDiscount(2);
        orderDetail.setOrderId(3);
        orderDetail.setProductId(4);
        orderDetail.setQuantity(152);
        orderDetail.setUnitPrice(1213);
        orders.add(orderDetail);

        order.setCustomerId(1);
        order.setEmployeeId(1);
        order.setOrderDetail(orders);
        order.setOrderDate(new Date());
        order.setShippingMethodId(1);

        orderService.saveOrUpdate(order);
		return "home";
	}
	
}
