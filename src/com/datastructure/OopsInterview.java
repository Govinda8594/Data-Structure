package com.datastructure;

public class OopsInterview {
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		System.out.println(Adder.add(11, 11));
		System.out.println(Adder.add(11, 11));
//		OverloadingCalculation3 obj = new OverloadingCalculation3();
//		obj.sum(20, 20);// now ambiguity
//		Bike2 obj = new Bike2();// creating object
//		obj.run(1, 2);// calling method
		Employee emp = new Employee("ABC");
		Company c = new Company(emp);
		Singleton singleton = Singleton.getSingleObject();

		try {
			throw new CustomException("Cannot be Null");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

class Adder {
	static int add(int a, int b) {
		return a + b;
	}

//	static void add(int a, int b) {
//		System.out.println("Passed");
//	} // compile time error
}

class Vehicle {
	// defining a method
	int run(int a, int b) {
		return a + b;
	}
}

//Creating a child class  
class Bike2 extends Vehicle {
//	defining the same method as in the parent class void
	@Override
	int run(int a, int b) {
		System.out.println("Bike is running safely");
		return b;
	} // compile time error
}

class Company {

	private Employee emp;

//	Contructor injection
	public Company(Employee emp) {
		this.emp = emp;
	}

	// Setter method
	public void setEmployee(Employee emp) {
		this.emp = emp;
	}

}

final class Employee {

	private String name;

	public Employee(String name) {
		this.name = name;
	}

}

//	Singleton Object
class Singleton {

	private String name;

	private Singleton(String name) {
		this.name = name;
	}

	public static Singleton getSingleObject() {

		return new Singleton("ABS");
	}

}

//	custom Exception
class CustomException extends NullPointerException {

	private String message;

	public CustomException(String msg) {
		this.message = msg;
	}

	void printMessage() {
		System.out.println(message);
	}
}
