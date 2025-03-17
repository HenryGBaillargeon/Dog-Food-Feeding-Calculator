package food;


public class Owner {
	
	// Private fields to hold owner's name, contact number, and activity level
    private String name;
    private String contactNumber;
    private String activityLevel;

    // Constructor 
    public Owner(String name, String contactNumber, String activityLevel) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.activityLevel = activityLevel;
    }

    // Getter for owners name
    public String getName() {
        return name;
    }

    // toString for owner's details to string for output
    @Override
    public String toString() {
        return String.format("Owner's Name: %s, Contact: %s, Activity Level: %s",
                name, contactNumber, activityLevel);
    }
}
