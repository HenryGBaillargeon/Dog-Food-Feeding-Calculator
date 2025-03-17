package food;


import java.util.List; // Imports List for handling collections of Dog objects

public class DogListProcessor { // Processes dog feeding amounts feeding totals
	
	// Static method, this recursively calcs the total feeding amount for all dogs
	public static double calculateTotalFeeding(List<Dog> dogs, int index) {
		
		if (index >= dogs.size()) {
			
			return 0; // Base case, end of list
		}
		
		// Recursively adds the current dog's feeding amount
		return dogs.get(index).calculateFeedingAmount() + calculateTotalFeeding(dogs, index + 1);
		
	}
	

}
