package it.unical.asde2018.shopping.components.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.unical.asde2018.shopping.components.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	private String usr;

	@RequestMapping("/productList")
	public String productList( HttpSession session, Model model) {
		model.addAttribute("products", productService.getProducts());
	    return "productList";
	}
	
	@RequestMapping({ "/buyProduct" })
    public String listProductHandler(HttpServletRequest request, Model model, HttpSession session,
    		@RequestParam(value = "productCode", defaultValue = "") String productCode,
    		@RequestParam(value = "productName", defaultValue = "") String productName,
    		@RequestParam(value = "productPrice", defaultValue = "") String productPrice) {
 	 	usr=(String) session.getAttribute("user");
    	if(usr == null) {
    		model.addAttribute("logged", "You are not logged!");
    	    return "login";
    	}
		model.addAttribute("itemCode",productCode);
		model.addAttribute("itemName",productName);
		model.addAttribute("itemPrice",productPrice);

	    return "shoppingChart";
    }
	
	@RequestMapping({ "/shoppingCartRemoveProduct" })
    public String removeProductHandler(HttpServletRequest request, Model model,
    		@RequestParam(value = "code", defaultValue = "") String code){
	    return "shoppingChart";
    }
	
}
