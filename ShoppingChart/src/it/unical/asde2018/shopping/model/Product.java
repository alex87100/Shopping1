package it.unical.asde2018.shopping.model;

public class Product {
	
	private String code;
    private String name;
    private double price;
    private byte[] image;
    
    public Product(String code,String name,double price) {
    	this.code = code;
		this.name = name;
		this.price = price;
	}
    
    public Product(String code) {
    	this.code = code;
	}
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
    
    

}
