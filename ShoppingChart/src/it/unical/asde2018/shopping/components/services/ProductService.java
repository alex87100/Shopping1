package it.unical.asde2018.shopping.components.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import it.unical.asde2018.shopping.model.Product;

@Service
public class ProductService {

	public List<Product> products = new ArrayList<Product>();
	private List<Product> basket = new CopyOnWriteArrayList<Product>(); // no problem with iterator
	// private Set<Product> basket = new HashSet<>();

	@PostConstruct
	public void init() {
		products.add(new Product("1", "men1", 90));
		products.add(new Product("2", "men2", 95));
		products.add(new Product("3", "men3", 60));
		products.add(new Product("4", "women1", 50));
		products.add(new Product("5", "women2", 55));
		products.add(new Product("6", "childBoy1", 35));
		products.add(new Product("7", "childBoy2", 30));
		products.add(new Product("8", "childGirl1", 25));
		products.add(new Product("9", "childGirl2", 15));

	}

	public List<Product> getProducts() {
		return products;
	}

	public List<Product> getProductsBasket() {
		return basket;
	}

	public Product GetProduct(String code) {
		Product product = null;
		for (Product p : products) {
			if (p.getCode().equals(code))
				product = p;
		}
		return product;
	}

	public Product GetProductBasket(String code) {
		Product product = null;
		for (Product p : basket) {
			if (p.getCode().equals(code))
				product = p;
		}
		return product;
	}

	public void addInBasket(String code, String name, double price) {
		Product product = new Product(code, name, price);
		basket.add(product);
	}

	public void removeInBasket(String code) {
		for (Product product : basket) {
			if (product.getCode().equals(code))
				basket.remove(product);
		}
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getName(String code) {
		String name = null;
		for (Product inserted : products) {
			if (inserted.getCode() == code) {
				name = inserted.getName();
			}
		}
		return name;
	}

}