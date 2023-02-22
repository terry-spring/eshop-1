package main.controller;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String getHome() {
		
		System.out.println("Password admin"+ PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"));
		System.out.println("Password employee"+ PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("employee"));
		System.out.println("Password client"+ PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("client"));
		return "index";
	}
}
