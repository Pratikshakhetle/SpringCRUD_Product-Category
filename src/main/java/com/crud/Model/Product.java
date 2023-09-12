package com.crud.Model;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;


@Entity
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productid;
	@Column(name="Product_Name")
	private String productname;
	@Column(name="Product_Price")
	private double price;
	@Column(name="Product_Quantity")
	private int quantity;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="category_id")
	private Category category;
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product() {
	}
	public Product(int productid, String productname, double price, int quantity) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	
}
