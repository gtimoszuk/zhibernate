package org.zhibernate.domain.samples.inheritance;

public class Rectangle extends Shape {

	public Rectangle(double width, double lenght) {
		super();
		this.width = width;
		this.lenght = lenght;
	}

	public Rectangle() {
		super();
	}

	private double width;
	
	private double lenght;
	
	@Override
	public double calculateArea() {
		return width * lenght;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLenght() {
		return lenght;
	}

	public void setLenght(double lenght) {
		this.lenght = lenght;
	}



}
