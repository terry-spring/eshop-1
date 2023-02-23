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

import main.model.Customer;
import main.repository.CustomerRepository;




@Controller
public class CustomerController {
	
//	@Autowired
//	private CustomerService customerService;
	
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/add-customer")
	public String showcForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerform";
	}
	
	@PostMapping("/process-customer-form")
	public String showCustomerData(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "customerform";
		}
		customerRepository.saveAndFlush(customer);
		return "redirect:show-customer";
	}
	
	@GetMapping("/show-customer")
	public String getCustomers(Model model) {
		List<Customer> customers = customerRepository.findAll();
		model.addAttribute("customers", customers);
		return "customers";
	}
	
	@GetMapping("/delete-customer/{customerId}")
	public String deleteCustomer(@PathVariable("customerId") long customerId) {
		Customer customer =  customerRepository.getOne(customerId);
		if(customer != null) {
			customerRepository.delete(customer);
		}
		return "redirect:/show-customer";
	}
	
	@GetMapping("/edit-customer/{customerId}")
	public String editCustomer(@PathVariable("customerId") long customerId, Model model) {
		Customer customer = customerRepository.getOne(customerId);
		if(customer != null) {
			model.addAttribute("customer", customer);
			return "customerform";
		}
		return "redirect:/show-customer";
	}
	
}
