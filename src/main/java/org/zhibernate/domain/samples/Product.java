package org.zhibernate.domain.samples;

import java.util.HashSet;
import java.util.Set;

public class Product {
	
	private Long id;
	
	private String name;
	
	public Product(String name) {
		super();
		this.name = name;
	}
	
	public Product() {
		
	}

	private Set<Part> parts = new HashSet<Part>();
	
	private Set<Part> multiParts = new HashSet<Part>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Part> getParts() {
		return parts;
	}

	public void setParts(Set<Part> parts) {
		this.parts = parts;
	}

	public void setMultiParts(Set<Part> multiParts) {
		this.multiParts = multiParts;
	}

	public Set<Part> getMultiParts() {
		return multiParts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
