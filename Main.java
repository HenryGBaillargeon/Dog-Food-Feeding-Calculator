package food;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        StringBuilder summary = new StringBuilder(); // Feeding summary text

        // Map for food brand, base serving sizes
        Map<String, Double> foodBaseServings = new HashMap<>();
        foodBaseServings.put("Purina", 0.5);
        foodBaseServings.put("Royal Canin", 0.5);
        foodBaseServings.put("Hill Science", 0.5);
        foodBaseServings.put("Natura", 0.4);
        
        
        // Get Owner Info
        System.out.println("Dog Food Serving Size Helper");
        System.out.println("-------------------------------");
        System.out.print("Owner's Name: "); // Prompts user to enter their name
        String ownerName = scanner.nextLine(); // Reads line of input
        System.out.println("-------------------------------");

        System.out.print("Owner's Contact Number: "); // Prompt for contact number
        String ownerContact = scanner.nextLine();
        System.out.println("-------------------------------");

        // Select Activity Level
        String activityLevel = selectActivityLevel(scanner); // Calls method to get activity level, thus passing the Scanner

        // Owner object with the activity level
        Owner owner = new Owner(ownerName, ownerContact, activityLevel);

        // Ask for number of dogs
        System.out.print("\nHow many dogs do you have? ");
        int numDogs = scanner.nextInt(); // Reads integer input for number of dogs
        scanner.nextLine(); // Consume leftover newline after nextInt() tp prevent line skipping
        System.out.println("-------------------------------");

        ArrayList<Dog> dogs = new ArrayList<>(); // Create ArrayList to store Dog objects

        // Dog Details
        for (int i = 0; i < numDogs; i++) { // Loop from 0 to numDogs to collect details for each dog
        	
            System.out.println("\nEnter details for Dog #" + (i + 1)); // Print header for each dog

            System.out.print("Dog's Name: ");  // Prompt for dog's name
            String dogName = scanner.nextLine(); // Reads the dogs names
            System.out.println("-------------------------------");
            
            
            System.out.print("Dog's Age (in years): "); // Prompt the dogs age
            double dogAge = scanner.nextDouble(); // Reads as a double 
            System.out.println("-------------------------------");

            System.out.print("Dog's Weight (in pounds): "); // Prompts the dog's weight
            double dogWeight = scanner.nextDouble();
            scanner.nextLine(); // Consume leftover newline
            System.out.println("-------------------------------");
            
            System.out.print("Dog's Breed: "); // Prompt for the dogs breed
            String breed = scanner.nextLine();
            System.out.println("-------------------------------");
            

            // Select Dog Food Brand
            String foodBrand = selectDogFoodBrand(scanner); // Call method to get the food brand, thus passing the Scanner

            // Create and add the Dog object
            Dog dog = new Dog(dogName, dogAge, dogWeight, foodBrand, breed); // Create a Dog object with all five parameters
            dogs.add(dog); // Add Dog object to the ArrayList
        }

        // Build Feeding Summary with visual spacing lines for clean foramtting
        summary.append("__________________________________\n"); // Horizontal line for summary formatting
        summary.append("--- Feeding Summary ---\n"); // Title for summary
        summary.append("__________________________________\n"); // Horizontal line seperation

        // Owner Information
        summary.append("Owner Information:\n");  // Header for owner details
        summary.append(owner).append("\n"); // Owner toString() output
        summary.append("__________________________________\n");

        // Dog Information and Feeding Details
        for (Dog dog : dogs) {  // Loops through each Dog in ArrayList
        	
            String size = DogFood.getSize(dog.getWeight()); // Call getSize()
            double servingSize = DogFood.calculateServingSize(size, dog.getAge(), dog.getFoodBrand()); // Call calculateFeedingAmount() from Feedable interface

            summary.append("Dog Information:\n");
            summary.append(dog).append("\n"); // Add Dog's toString() output
            summary.append("__________________________________\n"); // Seperator
            summary.append("Feeding Information:\n");
            summary.append("Size: ").append(size).append("\n"); // Add calculated size
            summary.append("Recommended Serving: ").append(servingSize).append(" cups/day\n"); // Add serving size
            summary.append("__________________________________\n");
        }
        
        // Calculate total feeding amount recursively
        double totalFeeding = DogListProcessor.calculateTotalFeeding(dogs, 0); // Call recursize method to sum all serving
        summary.append("Total Feeding Amount for All Dogs: ").append(totalFeeding).append(" cups/day\n"); // Add total to summary
        summary.append("__________________________________\n");
       
        System.out.println(summary); // Print feeding summary to console

     // Ask the user to name the files
        System.out.print("\nEnter a name for the summary files (without extension): ");
        String fileName = scanner.nextLine();

        // Save summary to text file text I/O
        saveToFile(fileName + ".txt", summary.toString());

        // Save dogs to binary file binary I/O,
        saveToBinaryFile(dogs, fileName); // Call saveToBinaryFile to save to dogs list

        scanner.close();
    }

    public static String selectActivityLevel(Scanner scanner) { // Method to get activity level from user input
        while (true) {
            System.out.println("\nSelect your activity level:"); // display menu header with 4 options
            System.out.println("1. Active");
            System.out.println("2. Regular");
            System.out.println("3. Inactive");
            System.out.println("4. High Activity");

            System.out.print("Enter your choice (1-4): "); // Number choice
            int choice = scanner.nextInt(); // Reads number choice
            scanner.nextLine(); // Consume leftover newline

            switch (choice) {
            
                case 1:
                    return "Active";
                case 2:
                    return "Regular";
                case 3:
                    return "Inactive";
                case 4:
                    return "High Activity";
                default:
                    System.out.println("Invalid choice. Please select a valid option."); // Error message for invalid input
            }
        }
    }

    // Method to get food brand from user input
    public static String selectDogFoodBrand(Scanner scanner) {
    	
        while (true) {
        	
            System.out.println("\nSelect your dog's food brand:"); // Display menu header with 4 options
            System.out.println("1. Purina");
            System.out.println("2. Royal Canin");
            System.out.println("3. Hill Science");
            System.out.println("4. Natura");

            System.out.print("Enter your choice (1-4): "); // Prompt for number choice
            int choice = scanner.nextInt(); // Reads number choice
            scanner.nextLine(); // Consume leftover newline

            switch (choice) { // Switch statement to handle choice
                case 1:
                    return "Purina";
                case 2:
                    return "Royal Canin";
                case 3:
                    return "Hill Science";
                case 4:
                    return "Natura";
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    // Method to write the summary to .txt file
    public static void saveToFile(String fileName, String content) {
    	
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) { // Try with resources opens a BufferedWriter, auto closes
        	
            writer.write(content); // Wrie summary string to file
            System.out.println("\nSummary successfully saved to " + fileName); // Confirms save to console
            
        } catch (IOException e) {
        	
            System.err.println("An error occurred while saving the summary: " + e.getMessage()); // Print error message
        }
    }
    
    
    // Method to write dogs list to binary file
    public static void saveToBinaryFile(ArrayList<Dog> dogs, String fileName) { 
    	
    	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName + ".bin"))) { // Open ObjectOutputStream
    		
    		oos.writeObject(dogs); // Write ArrayList<Dog> as a single object to file
    		System.out.println("Dog data saved to " + fileName + ".bin successfully."); // Confirm save
    		
    	} catch (IOException e) { // Catches any I/O error
    		
    		System.out.println("Error saving to binary file: " + e.getMessage()); // Print error message
    	}	
    }
}
