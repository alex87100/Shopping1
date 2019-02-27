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

	@RequestMapping("/productList")
	public String productList(HttpSession session, Model model) {
		model.addAttribute("products", productService.getProducts());
		return "productList";
	}

	@RequestMapping({ "/buyProduct" })
	public String listProductHandler(HttpServletRequest request, Model model, HttpSession session,
			@RequestParam(value = "code", defaultValue = "") String code,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "price", defaultValue = "") double price) {

		if (session.getAttribute("user") == null) {
			model.addAttribute("logged", "You are not logged!");
			return "login";
		}

		productService.addInBasket(code, name, price);
		session.setAttribute("basket", productService.getProductsBasket());

		return "shoppingChart";
	}

	@RequestMapping({ "/shoppingCartRemoveProduct" })
	public String removeProductHandler(HttpServletRequest request, Model model, HttpSession session,
			@RequestParam(value = "code", defaultValue = "") String code) {

		productService.removeInBasket(code);
		// session.setAttribute("basket", productService.getProductsBasket());

		return "shoppingChart";
	}

}
