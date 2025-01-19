import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder summary = new StringBuilder(); // To build the feeding summary text

        // Step 1: Get Owner Info
        System.out.print("Owner's Name: ");
        String ownerName = scanner.nextLine();

        System.out.print("Owner's Contact Number: ");
        String ownerContact = scanner.nextLine();

        // Step 2: Select Activity Level
        String activityLevel = selectActivityLevel(scanner);

        // Create an Owner object with the activity level
        Owner owner = new Owner(ownerName, ownerContact, activityLevel);

        // Step 3: Ask for number of dogs
        System.out.print("\nHow many dogs do you have? ");
        int numDogs = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        ArrayList<Dog> dogs = new ArrayList<>();

        // Step 4: Gather Dog Details
        for (int i = 0; i < numDogs; i++) {
            System.out.println("\nEnter details for Dog #" + (i + 1));

            System.out.print("Dog's Name: ");
            String dogName = scanner.nextLine();

            System.out.print("Dog's Age (in years): ");
            double dogAge = scanner.nextDouble();

            System.out.print("Dog's Weight (in pounds): ");
            double dogWeight = scanner.nextDouble();
            scanner.nextLine(); // Consume leftover newline

            // Select Dog Food Brand
            String foodBrand = selectDogFoodBrand(scanner);

            // Create and add the Dog object
            Dog dog = new Dog(dogName, dogAge, dogWeight, foodBrand);
            dogs.add(dog);
        }

        // Step 5: Build Feeding Summary with visual spacing lines
        summary.append("__________________________________\n");
        summary.append("--- Feeding Summary ---\n");
        summary.append("__________________________________\n");

        // Owner Information
        summary.append("Owner Information:\n");
        summary.append(owner).append("\n");
        summary.append("__________________________________\n");

        // Dog Information and Feeding Details
        for (Dog dog : dogs) {
            String size = DogFood.getSize(dog.getWeight());
            double servingSize = DogFood.calculateServingSize(size, dog.getAge(), dog.getFoodBrand());

            summary.append("Dog Information:\n");
            summary.append(dog).append("\n");
            summary.append("__________________________________\n");
            summary.append("Feeding Information:\n");
            summary.append("Size: ").append(size).append("\n");
            summary.append("Recommended Serving: ").append(servingSize).append(" cups/day\n");
            summary.append("__________________________________\n");
        }

        System.out.println(summary); // Print feeding summary to console

        // Ask the user to name the .txt file
        System.out.print("\nEnter a name for the summary file (without extension): ");
        String fileName = scanner.nextLine() + ".txt";

        // Save summary to the specified file
        saveToFile(fileName, summary.toString());

        scanner.close();
    }

    public static String selectActivityLevel(Scanner scanner) {
        while (true) {
            System.out.println("\nSelect your activity level:");
            System.out.println("1. Active");
            System.out.println("2. Regular");
            System.out.println("3. Inactive");
            System.out.println("4. High Activity");

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
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
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static String selectDogFoodBrand(Scanner scanner) {
        while (true) {
            System.out.println("\nSelect your dog's food brand:");
            System.out.println("1. Purina");
            System.out.println("2. Royal Canin");
            System.out.println("3. Hill Science");
            System.out.println("4. Natura");

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            switch (choice) {
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

    public static void saveToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("\nSummary successfully saved to " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while saving the summary: " + e.getMessage());
        }
    }
}
