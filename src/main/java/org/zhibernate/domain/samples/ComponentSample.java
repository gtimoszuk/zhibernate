package org.zhibernate.domain.samples;

public class ComponentSample {
	
	public ComponentSample(String someString, CompomentChild compomentChild) {
		super();
		this.someString = someString;
		this.compomentChild = compomentChild;
	}

	public ComponentSample() {
		
	}
	
	private Long id;

	private int version;
	
	private String someString;
	
	private CompomentChild compomentChild;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSomeString() {
		return someString;
	}

	public void setSomeString(String someString) {
		this.someString = someString;
	}

	public CompomentChild getCompomentChild() {
		return compomentChild;
	}

	public void setCompomentChild(CompomentChild compomentChild) {
		this.compomentChild = compomentChild;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

}
