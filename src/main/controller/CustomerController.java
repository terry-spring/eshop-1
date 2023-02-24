package main.controller;

import java.security.Principal;
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

import main.model.Customer;
import main.service.CustomerService;




@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/add-customer")
	public String showcForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@PostMapping("/process-customer-form")
	public String showCustomerData(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "customer-form";
		}
		customerService.saveOrUpdate(customer);
		return "redirect:show-customer";
	}
	
	@GetMapping("/show-customer")
	public String getCustomers(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customers";
	}
	
	@GetMapping("/delete-customer/{customerId}")
	public String deleteCustomer(@PathVariable("customerId") long customerId) {
		Customer customer =  customerService.getById(customerId);
		if(customer != null) {
			customerService.delete(customerId);
		}
		return "redirect:/show-customer";
	}
	
	@GetMapping("/edit-customer/{customerId}")
	public String editCustomer(@PathVariable("customerId") long customerId, Model model) {
		Customer customer = customerService.getById(customerId);
		if(customer != null) {
			model.addAttribute("customer", customer);
			return "customer-form";
		}
		return "redirect:/show-customer";
	}
	
	@GetMapping("/add-user-to-customer/{customerId}")
	public String addUserToCustomer(@PathVariable long customerId, Principal principal) {
		customerService.addUserToCustomer(customerId, principal.getName());
		return "redirect:/show-customer";
	}
}
