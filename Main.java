import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome Message
        System.out.println("_____________________________________________");
        System.out.println("Welcome to the Dog Food Feeding Calculator");
        System.out.println("_____________________________________________");

        // Step 1: Get Owner Info
        System.out.print("Owner's Name: ");
        String ownerName = scanner.nextLine();
        System.out.println("_____________________________________________");

        System.out.print("Owner's Contact Number: ");
        String ownerContact = scanner.nextLine();
        System.out.println("_____________________________________________");

        // Step 2: Select Activity Level
        String activityLevel = selectActivityLevel(scanner);

        // Create an Owner object with the activity level
        Owner owner = new Owner(ownerName, ownerContact, activityLevel);

        // Step 3: Ask for number of dogs
        System.out.print("\nHow many dogs do you have? ");
        int numDogs = scanner.nextInt();
        System.out.println("_____________________________________________");
        scanner.nextLine(); // Consume leftover newline

        ArrayList<Dog> dogs = new ArrayList<>();

        // Step 4: Gather Dog Details
        for (int i = 0; i < numDogs; i++) {
            System.out.println("\nEnter details for Dog #" + (i + 1));
            System.out.println("_____________________________________________");

            System.out.print("Dog's Name: ");
            String dogName = scanner.nextLine();

            System.out.print("Dog's Age (in years): ");
            double dogAge = scanner.nextDouble();
            System.out.println("_____________________________________________");

            System.out.print("Dog's Weight (in pounds): ");
            double dogWeight = scanner.nextDouble();
            System.out.println("_____________________________________________");
            scanner.nextLine(); // Consume leftover newline

            // Select Dog Food Brand
            String foodBrand = selectDogFoodBrand(scanner);

            // Create and add the Dog object
            Dog dog = new Dog(dogName, dogAge, dogWeight, foodBrand);
            dogs.add(dog);
        }

        // Step 5: Print Summary
        System.out.println("\n--- Feeding Summary ---");
        System.out.println("_____________________________________________");

        // Owner Details
        System.out.println("Owner Information:");
        System.out.println(owner);
        System.out.println("_____________________________________________");

        // Dog Details and Feeding Information
        for (Dog dog : dogs) {
            System.out.println("Dog Information:");
            System.out.println(dog);
            System.out.println("_____________________________________________");

            String size = DogFood.getSize(dog.getWeight());
            double servingSize = DogFood.calculateServingSize(size, dog.getAge(), dog.getFoodBrand());

            System.out.println("Feeding Information:");
            System.out.println("Size: " + size);
            System.out.println("Recommended Serving: " + servingSize + " cups/day");
            System.out.println("_____________________________________________");
        }

        scanner.close();
    }

    // Function to display activity level options and get user input
    public static String selectActivityLevel(Scanner scanner) {
        while (true) {
            System.out.println("\nSelect your activity level:");
            System.out.println("1. Active");
            System.out.println("2. Regular");
            System.out.println("3. Inactive");
            System.out.println("4. High Activity");

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            System.out.println("_____________________________________________");
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

    // Function to display dog food brand options and get user input
    public static String selectDogFoodBrand(Scanner scanner) {
        while (true) {
            System.out.println("\nSelect your dog's food brand:");
            System.out.println("1. Purina");
            System.out.println("2. Royal Canin");
            System.out.println("3. Hill Science");
            System.out.println("4. Natura");

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            System.out.println("_____________________________________________");
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
}
