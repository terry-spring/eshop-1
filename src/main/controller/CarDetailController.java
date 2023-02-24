package main.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarDetailController {

	//	
//	@GetMapping("/showCartDetails/{productId}")
//	public String showCartDetails(@PathVariable long productId, Model model) {
//		Tour tour = productService.getById(productId);
//		if(tour != null) {
//			tourService.addTourDetailsIfNotExists(tour);
//			model.addAttribute("tour", tour);
//			return "tour-details";
//		}
//		return "redirect:/showOffer";
}
