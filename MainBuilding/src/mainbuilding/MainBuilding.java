/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainbuilding;

/**
 *
 * @author Carla Mae
 */
import java.util.Scanner;

class Building {
    protected String address;
    protected int numberOfFloors;
    protected double totalArea;

    // Constructor
    public Building(String address, int numberOfFloors, double totalArea) {
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.totalArea = totalArea;
    }

    // Display building details
    public void displayDetails() {
        System.out.println("\n🏢 Building Details:");
        System.out.println("Address: " + address);
        System.out.println("Number of Floors: " + numberOfFloors);
        System.out.println("Total Area: " + totalArea + " sq.m");
    }

    // Method to calculate rent
    public double calculateTotalRent() {
        return 0.0;
    }
}

// Subclass: ResidentialBuilding
class ResidentialBuilding extends Building {
    private int numberOfApartments;
    private double rentPerApartment;

    // Constructor
    public ResidentialBuilding(String address, int numberOfFloors, double totalArea,
                               int numberOfApartments, double rentPerApartment) {
        super(address, numberOfFloors, totalArea);
        this.numberOfApartments = numberOfApartments;
        this.rentPerApartment = rentPerApartment;
    }

    // Override method to calculate rent
    @Override
    public double calculateTotalRent() {
        return numberOfApartments * rentPerApartment;
    }

    // Override display details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Apartments: " + numberOfApartments);
        System.out.println("Rent per Apartment: ₱" + rentPerApartment);
        System.out.println("Total Monthly Rent: ₱" + calculateTotalRent());
    }
}

// Subclass: CommercialBuilding
class CommercialBuilding extends Building {
    private double officeSpace; 
    private double rentPerSqm;

    // Constructor
    public CommercialBuilding(String address, int numberOfFloors, double totalArea,
                              double officeSpace, double rentPerSqm) {
        super(address, numberOfFloors, totalArea);
        this.officeSpace = officeSpace;
        this.rentPerSqm = rentPerSqm;
    }

    // Override method to calculate rent
    @Override
    public double calculateTotalRent() {
        return officeSpace * rentPerSqm;
    }

    // Override display details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Office Space: " + officeSpace + " sq.m");
        System.out.println("Rent per sq.m: ₱" + rentPerSqm);
        System.out.println("Total Monthly Rent: ₱" + calculateTotalRent());
    }
}

// Main class
public class MainBuilding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("===== BUILDING RENTAL SYSTEM =====");

        do {
            System.out.println("\n1. Residential Building");
            System.out.println("2. Commercial Building");
            System.out.println("3. Exit");
            System.out.print("Choose building type: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Address: ");
                    String rAddress = sc.nextLine();
                    System.out.print("Enter Number of Floors: ");
                    int rFloors = sc.nextInt();
                    System.out.print("Enter Total Area (sq.m): ");
                    double rArea = sc.nextDouble();
                    System.out.print("Enter Number of Apartments: ");
                    int apartments = sc.nextInt();
                    System.out.print("Enter Rent per Apartment (₱): ");
                    double rentPerApt = sc.nextDouble();

                    ResidentialBuilding rb = new ResidentialBuilding(rAddress, rFloors, rArea, apartments, rentPerApt);
                    rb.displayDetails();
                    break;

                case 2:
                    System.out.print("Enter Address: ");
                    String cAddress = sc.nextLine();
                    System.out.print("Enter Number of Floors: ");
                    int cFloors = sc.nextInt();
                    System.out.print("Enter Total Area (sq.m): ");
                    double cArea = sc.nextDouble();
                    System.out.print("Enter Office Space (sq.m): ");
                    double office = sc.nextDouble();
                    System.out.print("Enter Rent per sq.m (₱): ");
                    double rentPerSqm = sc.nextDouble();

                    CommercialBuilding cb = new CommercialBuilding(cAddress, cFloors, cArea, office, rentPerSqm);
                    cb.displayDetails();
                    break;

                case 3:
                    System.out.println("👋 Exiting program...");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}