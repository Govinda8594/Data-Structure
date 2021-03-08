package com.datastructure;

public class Name {
	private String firstName;
	private String lastName;
	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.toLowerCase().hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.toLowerCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (firstName.toLowerCase().equals(other.firstName.toLowerCase()))
			return true;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (lastName.toLowerCase().equals(other.lastName.toLowerCase()))
			return true;
		return false;
		
	}
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	
}
