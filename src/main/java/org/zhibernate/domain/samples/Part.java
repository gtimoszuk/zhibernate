package org.zhibernate.domain.samples;

import java.util.HashSet;
import java.util.Set;

public class Part {
	
	private Long id;
	
	private String name;
	
	public Part(String name) {
		super();
		this.name = name;
	}
	
	public Part() {
		
	}

	private Set<Product> products = new HashSet<Product>();

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
