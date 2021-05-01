package com.datastructure.stringarryoperation;

import java.util.HashMap;
import java.util.Map;

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
		} else if (!firstName.equals(other.firstName))
			return true;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return true;
		return false;

	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public static void main(String[] args) {
		Name[] names = { new Name("Navin", "Kabra"), 
				         new Name("Amit", "Paranjape"), 
				         new Name("NAVIN", "KABRA"),
				         new Name("AMIT", "paranjape"), 
				         new Name("Navin", "Kotkar"), 
				         new Name("Gaurav", "Kotkar"),
				         new Name("Gaurav", "KOTKAR") };
		
		Map<Name, Integer> hash = new HashMap<Name, Integer>();
		for (Name n : names) {
			Integer numOccurrences = hash.get(n);
			if (numOccurrences != null) {
				hash.put(n, numOccurrences + 1);
			} else {
				hash.put(n, 1);
			}
		}
		System.out.println(hash.toString() + "\n");
		for (Name name : names) {
			System.out.println(name);
		}
		printDuplicates(hash);
	}

	public static void printDuplicates(Map<Name, Integer> names) {
		for (Map.Entry<Name, Integer> entry : names.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey());
			}
		}
	}

}
