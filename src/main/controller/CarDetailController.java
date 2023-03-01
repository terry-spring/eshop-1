package main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import main.model.CartDetail;
import main.service.CartDetailService;

@Controller
public class CarDetailController {

    @Autowired
    private CartDetailService cartDetailService;

    @PostMapping("/process-cartdetail-form")
    public String showCartDetailData(@Valid @ModelAttribute CartDetail cartDetail, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "cart";
        }
        cartDetailService.saveOrUpdate(cartDetail);
        return "redirect:show-cartDetail";
    }
}