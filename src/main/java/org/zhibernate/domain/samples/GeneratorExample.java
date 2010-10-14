package org.zhibernate.domain.samples;

public class GeneratorExample {
	
	public GeneratorExample() {
		
	}
	
	public GeneratorExample(String text) {
		this.text = text;
	}
	
	Long id;
	
	String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
