package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// mapping with index page
	// @RequestMapping("/login")
	@PostMapping("/login")
	public String login(@ModelAttribute(name = "loginForm") LoginBean loginBean, Model m) {
		// Get the input values from the index page
		String username = loginBean.getUsername();
		String password = loginBean.getPassword();
		String message;

		boolean checkResult = loginBean.checkCredentials(username, password);

		if (checkResult) {
			message = "Welcome to the Homepage";
			m.addAttribute("message", message);
			m.addAttribute("username", username);
			// return to the success-login Thymeleaf page
			return "success-login";
		} else {
			message = "Invalid credentials.";
			m.addAttribute("message", message);
			// return to the error-login Thymeleaf page
			return "error-login";
		}

	}

	@RequestMapping("/welcome")
	//@GetMapping("/welcome")
	public ModelAndView printMessage(
			@RequestParam(value = "name", required = false, defaultValue = "Hi") String name) {
		String message = "Welcome to Spring MVC";
		ModelAndView mview = new ModelAndView("success-login");
		mview.addObject("message", message);
		mview.addObject("username", name);
		return mview;
	}

}
