package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**建構登入功能
 * @author richard
 *
 */
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	
}
