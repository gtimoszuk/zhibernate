package org.zhibernate.domain.samples;

public class CompomentChild {
	
	private String childString;
	
	private String anotherString;

	public CompomentChild() {
		
	}

	public CompomentChild(String childString, String anotherString) {
		super();
		this.childString = childString;
		this.anotherString = anotherString;
	}

	public String getAnotherString() {
		return anotherString;
	}

	public void setAnotherString(String anotherString) {
		this.anotherString = anotherString;
	}

	public String getChildString() {
		return childString;
	}

	public void setChildString(String childString) {
		this.childString = childString;
	}
}
