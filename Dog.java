package food;

import java.io.Serializable; // For binary file operations

public class Dog extends Animal implements Feedable, Serializable { // Extends Animal and implements Feedable
    
	// Identifier for serialization compat.
	private static final long serialVersionUID = 1L;
	
	// Private fields for dog attributes 
	private double weight;
	private String foodBrand;
	private String breed;
	
	
    // Constructor 
    public Dog(String name, double age, double weight, String foodBrand, String breed) {
        super(name, age);
        this.weight = weight;
        this.foodBrand = foodBrand;
        this.breed = breed;
    	
    	
    }

    // Getters

    public double getWeight() {
        return weight;
    }

    public String getFoodBrand() {
        return foodBrand;
    }
    
    // Override the Animal's abstract method to return the dog's breed
    @Override
    public String getBreed() {
    	return breed;
    }
    
    
    // Implements Feedable
    @Override
    public double calculateFeedingAmount() {
    	String size = DogFood.getSize(this.getWeight());
    	return DogFood.calculateServingSize(size, this.getAge(), this.getFoodBrand());
    }
    

    // Custom method to display details
    @Override
    public String toString() {
        return String.format(
                "Dog's Name: %s\nAge: %.1f years\nWeight: %.2f lbs\nFood Brand: %s\nBreed: %s",
                getName(), getAge(), weight, foodBrand, breed
        );
    }
}

