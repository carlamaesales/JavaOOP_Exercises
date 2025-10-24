/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainpet;

/**
 *
 * @author Carla Mae
 */
import java.util.*;

class Pet {
    protected String name;
    protected String species;
    protected int age;

    // Constructor
    public Pet(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    // Method to display pet details
    public void displayDetails() {
        System.out.println("\n🐾 Pet Details:");
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Age: " + age + " years");
    }

    // Method to calculate age in human years 
    public double calculateHumanYears() {
        return age * 7;
    }
}

// Subclass: Dog
class Dog extends Pet {
    private String favoriteToy;

    public Dog(String name, int age, String favoriteToy) {
        super(name, "Dog", age);
        this.favoriteToy = favoriteToy;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Favorite Toy: " + favoriteToy);
        System.out.println("Age in Human Years: " + calculateHumanYears());
    }

    @Override
    public double calculateHumanYears() {
        return age * 7;
    }
}

// Subclass: Bird
class Bird extends Pet {
    private double wingspan;

    public Bird(String name, int age, double wingspan) {
        super(name, "Bird", age);
        this.wingspan = wingspan;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Wingspan: " + wingspan + " cm");
        System.out.println("Age in Human Years: " + calculateHumanYears());
    }

    @Override
    public double calculateHumanYears() {
        return age * 5;
    }
}

// Main class
public class MainPet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== PET INFORMATION SYSTEM =====");
        System.out.println("1. Dog");
        System.out.println("2. Bird");
        System.out.print("Choose a pet type: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("\nEnter Pet Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Pet Age (in years): ");
        int age = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter Favorite Toy: ");
            String toy = sc.nextLine();
            Dog dog = new Dog(name, age, toy);
            dog.displayDetails();
        } else if (choice == 2) {
            System.out.print("Enter Wingspan (in cm): ");
            double wingspan = sc.nextDouble();
            Bird bird = new Bird(name, age, wingspan);
            bird.displayDetails();
        } else {
            System.out.println("❌ Invalid choice.");
        }

        sc.close();
    }
}