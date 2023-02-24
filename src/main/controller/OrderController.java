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

import main.model.Order;
import main.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order")
	public String getOrder() {
		return "orders";
	}
	
	@GetMapping("/show-order")
	public String getOrders(Model model) {
		List<Order> orders = orderService.getAll();
		model.addAttribute("orders", orders);
		return "orders";
	}
	
	@GetMapping("/add-order")
	public String showForm(Model model) {
		model.addAttribute("order", new Order());
		return "order-form";
	}
	
	@PostMapping("/process-order-form")
	public String showOrderData(@Valid @ModelAttribute Order order, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "order-form";
		}
		orderService.saveOrUpdate(order);
		return "redirect:show-order";
	}
	
	@GetMapping("/delete-order/{id}")
	public String deleteOrder(@PathVariable long id) {
		Order order = orderService.getById(id);
		if(order != null) {
			orderService.delete(id);
		}
		return "redirect:/show-order";
	}
	
	@GetMapping("/edit-order/{id}")
	public String editOrder(@PathVariable int id, Model model) {
		Order order = orderService.getById(id);
		if(order != null) {
			model.addAttribute("order", order);
			return "order-form";
		}
		return "redirect:/show-order";
	}
	
}
