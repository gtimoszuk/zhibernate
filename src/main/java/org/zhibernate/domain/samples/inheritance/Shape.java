package org.zhibernate.domain.samples.inheritance;

public abstract class Shape {

	Long id;
	
	public abstract double calculateArea();
	
	public Shape() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
