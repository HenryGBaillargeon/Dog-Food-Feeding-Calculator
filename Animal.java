package food;

import java.io.Serializable;


public abstract class Animal implements Serializable { // This abstract class that can be saved to binary files
	
	// Identifier for serialization compatibility 
    private static final long serialVersionUID = 1L;
    
    // Private fields to store the animals name and age
	private String name;
	private double age;
	
	// Constructor that initializes animal with name and age
	public Animal(String name, double age) {
		
		this.name = name;
		this.age = age;
		
	}
	
	// Getters
	public String getName() {
		
		return name;
	}
	
	public double getAge() {
		
		return age;
		
	}
	
	// Abstract method
	public abstract String getBreed();
	

	
}
