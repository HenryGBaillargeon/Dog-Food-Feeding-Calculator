-----------------------------------------------------------------------------------------------------------------------------------------------------
🐾 Dog Food Management Helper Program 🥫

Welcome to the **Dog Food Feeding Calculator**, a Java-based application designed to assist dog owners in determining the proper serving size of dog food for their furry companions. This project showcases my programming skills in **Java**, file handling, object-oriented programming, and user interaction, making it an ideal portfolio project for showcasing my technical abilities as an aspiring software developer.


🚀 Features
Personalized Feeding Calculator: Computes ideal serving sizes based on a dog’s weight, age, breed, and food brand.

Interactive User Interface: Guides users through inputting owner and dog details via a clear command-line experience.

Dual File Output: Saves detailed summaries to .txt files (readable) and .bin files (compact) for flexibility.

Recursive Efficiency: Calculates total feeding amounts across multiple dogs using recursion.

Advanced Data Handling: Leverages ArrayList for dog data and HashMap for food brand servings, enhancing performance.


## 📂 Project Structure

### **Files Overview**
1. **`Main.java`**  
   - Entry point for the app.  
   - Handles input, calculations, and file I/O (text + binary).  
   - Features formatted output with separators.
     

2. **`Dog.java`**  
   - Models a dog with:  
     - Name  
     - Age  
     - Weight  
     - Food Brand  
     - Breed  
   - Extends `Animal`, implements `Feedable`.
     

3. **`Owner.java`**  
   - Stores owner info:  
     - Name  
     - Contact Number  
     - Activity Level
       

4. **`DogFood.java`**  
   - Logic for:  
     - Size classification (Small/Medium/Large)  
     - Serving size calculations
       

5. **`Animal.java`**  
   - Abstract base with name and age.
     

6. **`Feedable.java`**  
   - Interface for feeding calculations.
     

7. **`DogListProcessor.java`**  
   - Recursive feeding total calculator.
     
  
   
1. **Clone the Repository**:  
   ```bash
   git clone https://github.com/HenryGBaillargeon/Dog-Food-Feeding-Calculator.git
   cd Dog-Food-Feeding-Calculator




   ---------------------------------------------------------------------------------------------------------------------------------------------------
