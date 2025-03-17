package food;


public class DogFood {

	// This classifies a dog small, medium or large based on weight in pounds
    public static String getSize(double weight) {
    	
        if (weight <= 20) {
        	
            return "Small";
        } else if (weight <= 50) {
        	
            return "Medium";
        } else {
        	
            return "Large";
        }
    }

    // Calculates feeding amount in cups, will also adjust for dog size, age, and food brand
    public static double calculateServingSize(String size, double age, String brand) {
        double serving;

        // Switch statement to set serving size based on brand, also special units for natura
        switch (brand.toLowerCase()) {
        
            case "purina":
            case "royal canin":
            case "hill science":
                if (size.equals("Small")) {
                    serving = (age <= 1) ? 0.5 : 1.0;
                } else if (size.equals("Medium")) {
                	
                    serving = (age <= 1) ? 1.0 : 1.5;
                } else {
                    serving = (age <= 1) ? 1.5 : 2.5;
                }
                break;

            case "natura":
                if (size.equals("Small")) {
                	
                    serving = (age <= 1) ? 0.4 : 0.8;
                } else if (size.equals("Medium")) {
                	
                    serving = (age <= 1) ? 0.9 : 1.3;
                } else {
                	
                    serving = (age <= 1) ? 1.4 : 2.2;
                }
                break;

            default: // Returns 0 for unreconized brands
                serving = 0.0;
        }

        return serving;
    }
}
