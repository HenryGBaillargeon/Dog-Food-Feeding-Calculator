# 🐾 Dog Food Feeding Calculator

Welcome to the **Dog Food Feeding Calculator**, a Java-based application designed to assist dog owners in determining the proper serving size of dog food for their furry companions. This project showcases my programming skills in **Java**, file handling, object-oriented programming, and user interaction, making it an ideal portfolio project for showcasing my technical abilities as an aspiring software developer.

## 🚀 Features

- **Dynamic Feeding Calculator**: Determine the ideal serving size based on your dog's weight, age, and preferred food brand.
- **Interactive User Input**: Easily input owner and dog details through an intuitive command-line interface.
- **File Handling**: Save feeding summaries to customizable `.txt` files for future reference, complete with visual separators for readability.
- **Object-Oriented Design**: Efficiently handles owner and dog data using well-structured classes.
- **Customizable Options**: Select dog food brands and activity levels dynamically through numbered menus.


## 📂 Project Structure

### **Files Overview**
1. **`Main.java`**
   - Acts as the entry point of the program.
   - User interaction, gathers data, calculates feeding requirements, and saves results to a file.
   - Implements features like dynamic file naming and formatted console/file output.

2. **`Dog.java`**
   - Represents individual dog entities with properties like:
     - Name
     - Age
     - Weight
     - Food brand
   - Includes a `toString()` method for neatly formatted output.

3. **`Owner.java`**
   - Represents the dog owner, storing details like:
     - Name
     - Contact number
     - Activity level (e.g., Active, Regular, Inactive).
   - Includes a `toString()` method for clear and concise owner information.

4. **`DogFood.java`**
   - Contains logic for:
     - Determining the size category of a dog (Small, Medium, Large) based on weight.
     - Calculating the recommended serving size based on dog size, age, and food brand.

## 📝 How to Run the Program

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/Dog-Food-Feeding-Calculator.git
   cd Dog-Dood-Feeding-Calculator
