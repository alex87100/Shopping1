package it.unical.asde2018.shopping.components.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.asde2018.shopping.components.services.LoginService;
import it.unical.asde2018.shopping.model.Account;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	// GET: Show Login Page
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping("/loginAttempt")
	public String loginAttempt(@RequestParam String userName, @RequestParam String password, HttpSession session,
			Model model) {
		if (loginService.login(userName, password)) {
			session.setAttribute("user", loginService.getAccount(userName));
			// System.out.println("login");
			return "accountInfo";
		}
		model.addAttribute("error", "Wrong credentials!");
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		// System.out.println("logout");
		session.invalidate();
		return "login";
	}

	// GET: Enter customer information. Redirect to edit page. "redirect:/edit"
	@RequestMapping(value = { "/shoppingCartCustomer" }, method = RequestMethod.GET)
	public String shoppingCartCustomerForm(HttpServletRequest request, Model model) {
		return "edit";
	}

	@RequestMapping("/edit")
	public String editInformation(@RequestParam String name, @RequestParam String surname, @RequestParam String email,
			@RequestParam String address, @RequestParam String phone, HttpSession session, Model model) {

		Account current = (Account) session.getAttribute("user");
		loginService.setName(current.getUsername(), name);
		loginService.setSurname(current.getUsername(), surname);
		loginService.setEmail(current.getUsername(), email);
		loginService.setAddress(current.getUsername(), address);
		loginService.setPhone(current.getUsername(), phone);

		return "accountInfo";
	}

	@RequestMapping("/shoppingCart")
	public String shoppingChart(HttpSession session, Model model) {
		Account current = (Account) session.getAttribute("user");
		if (current == null) {
			model.addAttribute("logged", "You are not logged!");
			return "login";
		}
		return "shoppingChart";
	}

}
