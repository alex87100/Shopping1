package it.unical.asde2018.shopping.components.services;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import it.unical.asde2018.shopping.model.Product;

@Service
public class ProductService {
	
	public Set<Product> products = new HashSet<>();
	
	@PostConstruct
	public void init() {
		products.add(new Product("1","SerieA",10));	
		products.add(new Product("2","Premier",10));	
		products.add(new Product("3","LaLiga",10));	
		products.add(new Product("4","Juve",25));	
	}
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getName(String code) {
		String name = null;
		for (Product inserted : products) {
			if(inserted.getCode() == code) {
				name = inserted.getName();
			}
		}
		return name;		
	}


}