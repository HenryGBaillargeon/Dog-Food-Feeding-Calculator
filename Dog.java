//Dog Food Measurement Program
import java.util.*;

public class Dog {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Dog Simulation Program!");

        List<String> dogNames = new ArrayList<>();




        // Keep asking for dogs names until the user concludes input

        while (true) {
            System.out.print("Enter the name of your dog (or type 'done' to finish): ");
            String dogName = scanner.nextLine().trim();

            // Check if the user wants to conclude input
            if (dogName.equalsIgnoreCase("done")) {
                break;
            }
            // Add the dog's names to the list
            dogNames.add(dogName);

        }
        // Display the lise of dog names collected
        System.out.println("\nYou have entered the following dog names:");
                for (String name : dogNames) {
                    System.out.println("- " + name);
                }
                // Proceed with the rest of the program
        System.out.println("\nContinue with the program...\n");


    }
}
