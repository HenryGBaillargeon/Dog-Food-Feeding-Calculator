public class Owner {
    private String name;
    private String contactNumber;
    private String activityLevel;

    public Owner(String name, String contactNumber, String activityLevel) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.activityLevel = activityLevel;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Owner's Name: %s, Contact: %s, Activity Level: %s",
                name, contactNumber, activityLevel);
    }
}
