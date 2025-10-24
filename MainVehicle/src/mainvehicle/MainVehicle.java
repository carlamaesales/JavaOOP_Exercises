/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainvehicle;

/**
 *
 * @author Carla Mae
 */
import java.util.Scanner;

class Vehicle {
    // Attributes
    private String make;
    private String model;
    private int year;

    // Constructor
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getter methods
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("🚘 Vehicle: " + year + " " + make + " " + model);
    }
}

// Subclass for Car
class Car extends Vehicle {
    private double trunkSize; // in cubic feet

    public Car(String make, String model, int year, double trunkSize) {
        super(make, model, year);
        this.trunkSize = trunkSize;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n🚗 Car Details:");
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Trunk Size: " + trunkSize + " cubic feet");
    }
}

// Subclass for Truck
class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(String make, String model, int year, double payloadCapacity) {
        super(make, model, year);
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n🚚 Truck Details:");
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Payload Capacity: " + payloadCapacity + " kg");
    }
}

// Main Class
public class MainVehicle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== VEHICLE INFORMATION SYSTEM =====");
            System.out.println("1. Create Car");
            System.out.println("2. Create Truck");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Car Make: ");
                    String makeC = input.nextLine();
                    System.out.print("Enter Car Model: ");
                    String modelC = input.nextLine();
                    System.out.print("Enter Year: ");
                    int yearC = input.nextInt();
                    System.out.print("Enter Trunk Size (in cubic feet): ");
                    double trunk = input.nextDouble();
                    Car car = new Car(makeC, modelC, yearC, trunk);
                    car.displayDetails();
                    break;

                case 2:
                    System.out.print("Enter Truck Make: ");
                    String makeT = input.nextLine();
                    System.out.print("Enter Truck Model: ");
                    String modelT = input.nextLine();
                    System.out.print("Enter Year: ");
                    int yearT = input.nextInt();
                    System.out.print("Enter Payload Capacity (in kg): ");
                    double payload = input.nextDouble();
                    Truck truck = new Truck(makeT, modelT, yearT, payload);
                    truck.displayDetails();
                    break;

                case 3:
                    System.out.println("🚘 Exiting program... Goodbye!");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice! Please try again.");
            }

        } while (choice != 3);

        input.close();
    }
}