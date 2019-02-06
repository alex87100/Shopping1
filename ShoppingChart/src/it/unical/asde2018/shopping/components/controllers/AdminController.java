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

@Controller
public class AdminController {
	
	@Autowired
	private LoginService loginService;
	private String usr;

	
    // GET: Show Login Page
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }
    
    // GET: Show Login Page
    @RequestMapping("/loginAttempt")
    public String loginAttempt(@RequestParam String userName, @RequestParam String password, HttpSession session, Model model) {
    	if(loginService.login(userName,password)) {
			session.setAttribute("user",userName);
			model.addAttribute("name",loginService.getName(userName));
			model.addAttribute("surname",loginService.getSurname(userName));
			model.addAttribute("email",loginService.getEmail(userName));
			model.addAttribute("address",loginService.getAddress(userName));
			model.addAttribute("phone",loginService.getPhone(userName));
	    	System.out.println("login");
			return "accountInfo";
		}
    	//session.setAttribute("user", userName);
		model.addAttribute("error", "Wrong credentials!");
		return "login";
    }
    
    @RequestMapping("/logout")
    public String logout( HttpSession session, Model model) {
    	System.out.println("logout");
    	session.invalidate();
        return "login";
    }
    
    // GET: Enter customer information.
    @RequestMapping(value = { "/shoppingCartCustomer" }, method = RequestMethod.GET)
    public String shoppingCartCustomerForm(HttpServletRequest request, Model model) {
        // Redirect to edit page. "redirect:/edit"
        return "edit";
    }
    
    // GET: Show Login Page
    @RequestMapping("/edit")
    public String editInformation(@RequestParam String name,HttpSession session, Model model) {
    	usr=(String) session.getAttribute("user");
    	loginService.setName(usr, name);
    	//WHY I have to reassign everything
		model.addAttribute("name",loginService.getName(usr));
		model.addAttribute("surname",loginService.getSurname(usr));
		model.addAttribute("email",loginService.getEmail(usr));
		model.addAttribute("address",loginService.getAddress(usr));
		model.addAttribute("phone",loginService.getPhone(usr));
    	System.out.println("login");
		return "accountInfo";
    }

	@RequestMapping("/shoppingCart")
	public String shoppingChart( HttpSession session, Model model) {
    	usr=(String) session.getAttribute("user");
    	if(usr == null) {
    		model.addAttribute("logged", "You are not logged!");
    	    return "login";
    	}
	    return "shoppingChart";
	}    
 

}
