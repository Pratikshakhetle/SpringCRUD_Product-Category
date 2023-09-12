package com.crud.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
 private int id;
@Column(name="Title")
 private String title;

@OneToMany(mappedBy="category",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
private List<Product> product;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return title;
}
public void setName(String name) {
	this.title = name;
}
public Category(int id, String name) {
	this.id = id;
	this.title = name;
}
public List<Product>getProduct(List<Product>product){
	return product;
}
public void setProduct(List<Product>product) {
	this.product=product;
}

public Category() {
}

@Override
public String toString() {
	return "Category [Id=" + id + ", Title=" + title + "]";
}

}