/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dogoop;

/**
 *
 * @author Carla Mae
 */
public class DogOOP {

    // Attributes
    private String name;
    private String breed;

    // Constructor to set name and breed
    public DogOOP(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for breed
    public String getBreed() {
        return breed;
    }

    // Setter for breed
    public void setBreed(String breed) {
        this.breed = breed;
    }

    // Main method to create instances, modify, and print
    public static void main(String[] args) {
        
        DogOOP dog1 = new DogOOP("Buddy", "Golden Retriever");
        DogOOP dog2 = new DogOOP("Max", "Bulldog");

       
        System.out.println("Initial Dog 1: Name = " + dog1.getName() + ", Breed = " + dog1.getBreed());
        System.out.println("Initial Dog 2: Name = " + dog2.getName() + ", Breed = " + dog2.getBreed());

        // Modify attributes using setters
        dog1.setName("Charlie");
        dog1.setBreed("Labrador");
        dog2.setName("Rex");
        dog2.setBreed("Poodle");

        // Print updated values
        System.out.println("\nUpdated Dog 1: Name = " + dog1.getName() + ", Breed = " + dog1.getBreed());
        System.out.println("Updated Dog 2: Name = " + dog2.getName() + ", Breed = " + dog2.getBreed());
    }
}