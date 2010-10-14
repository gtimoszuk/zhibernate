package org.zhibernate.domain.samples;

import java.io.Serializable;

public class CompositeIdExample implements Serializable {
	
	private static final long serialVersionUID = 9047658737441336562L;

	String name;
	
	String surname;
	
	String nick;

	public CompositeIdExample(String name, String surname, String nick) {
		super();
		this.name = name;
		this.surname = surname;
		this.nick = nick;
	}


	public CompositeIdExample() {
		
	}
	
	public CompositeIdExample(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CompositeIdExample)) {
			return false;
		}
		CompositeIdExample other = (CompositeIdExample) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (nick == null) {
			if (other.nick != null) {
				return false;
			}
		} else if (!nick.equals(other.nick)) {
			return false;
		}
		return true;
	}
	

}
