package it.unical.asde2018.shopping.components.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.asde2018.shopping.components.services.LoginService;

@Controller
public class RegistrationController {

	@Autowired
	private LoginService loginService;

	// GET: Show Register Page
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String register(Model model) {
		return "register";
	}

	@RequestMapping("/registrationAttempt")
	public String registrationAttempt(@RequestParam String name, @RequestParam String surname,
			@RequestParam String email, @RequestParam String address, @RequestParam String phone,
			@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {

		if (!loginService.exist(username)) {
			loginService.addAccount(name, surname, email, address, phone, username, password);
			model.addAttribute("logged", "You can now login");
			return "login";
		}
		model.addAttribute("error", "Username already exist!");
		return "login";
	}

}
