public class DogFood {

    private final String dogName;
    private final double dogAge; // Dog's age in years.
    private final double dogWeight; // Dog's weight in pounds
    private final String brand; // Dog foood brand;


    public DogFood(String dogName, double dogAge, double dogWeight, String brand) {
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogWeight = dogWeight;
        this.brand = brand;
    }

    public String getDogName() {
dogName; }

    public String getSize() {
        if (dogWeight < 25) {
            return "Small";
        } else if (dogWeight < 50) {
            return "Medium";
        } else {
            return "Large";
        }

    }

    public String getBrand() {
        return brand;
    }

    public double calculateservingSize() {
        String size = getSize();

        switch (brand.toLowerCase()) {
            case "Purina":
                if (size.equalsIgnoreCase("Small"))
                    return (dogAge <= 1) ? 0.5 : 1.0;
                else if (size.equalsIgnoreCase("Medium"))
                    return (dogAge <= 1) ? 1.0 : 1.5;
                else return (dogAge <= 1) ? 1.5 : 2.5;
        }

}
