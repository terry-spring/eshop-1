package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import main.model.Tour;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String getHome(Model model) {
		model.addAttribute("tour",new Tour());
		return "index";
	}
	
}
