public class Dog {
    private String name;
    private double age;
    private double weight;
    private String foodBrand;

    // Constructor
    public Dog(String name, double age, double weight, String foodBrand) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.foodBrand = foodBrand;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getFoodBrand() {
        return foodBrand;
    }

    // Custom method to display details
    @Override
    public String toString() {
        return String.format(
                "Dog's Name: %s\nAge: %.1f years\nWeight: %.2f lbs\nFood Brand: %s",
                name, age, weight, foodBrand
        );
    }
}
