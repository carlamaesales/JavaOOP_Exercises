/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainelectronicproduct;

/**
 *
 * @author Carla Mae
 */
import java.util.Scanner;

class ElectronicsProduct {
    // Attributes
    protected String productID;
    protected String name;
    protected double price;

    // Constructor
    public ElectronicsProduct(String productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    // Method to apply a discount
    public void applyDiscount(double discountPercent) {
        if (discountPercent > 0 && discountPercent <= 100) {
            double discountAmount = price * (discountPercent / 100);
            price -= discountAmount;
            System.out.println("💸 Discount of " + discountPercent + "% applied. New price: ₱" + price);
        } else {
            System.out.println("⚠️ Invalid discount percentage!");
        }
    }

    // Method to calculate final price
    public double getFinalPrice() {
        return price;
    }

    // Display product details
    public void displayDetails() {
        System.out.println("\n📦 Product Details:");
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Price: ₱" + price);
    }
}

// Subclass: WashingMachine
class WashingMachine extends ElectronicsProduct {
    private int warrantyPeriod;

    // Constructor
    public WashingMachine(String productID, String name, double price, int warrantyPeriod) {
        super(productID, name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    // Method to extend the warranty
    public void extendWarranty(int additionalYears) {
        if (additionalYears > 0) {
            warrantyPeriod += additionalYears;
            System.out.println("🛠️ Warranty extended by " + additionalYears + " year(s). New warranty: " + warrantyPeriod + " years.");
        } else {
            System.out.println("⚠️ Invalid number of years to extend warranty!");
        }
    }

    // Override display method
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Warranty Period: " + warrantyPeriod + " years");
    }
}

// Main class
public class MainElectronicProduct   {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== ELECTRONICS PRODUCT MANAGEMENT =====");

        // Input product details
        System.out.print("Enter product ID: ");
        String id = sc.nextLine();

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter product price: ₱");
        double price = sc.nextDouble();

        System.out.print("Enter warranty period (in years): ");
        int warranty = sc.nextInt();

        // Create a WashingMachine object
        WashingMachine wm = new WashingMachine(id, name, price, warranty);
        wm.displayDetails();

        // Apply a discount
        System.out.print("\nEnter discount percentage to apply: ");
        double discount = sc.nextDouble();
        wm.applyDiscount(discount);

        // Extend warranty
        System.out.print("\nEnter additional warranty years to extend: ");
        int addYears = sc.nextInt();
        wm.extendWarranty(addYears);

        // Final details
        System.out.println("\n===== FINAL PRODUCT INFORMATION =====");
        wm.displayDetails();
        System.out.println("Final Price: ₱" + wm.getFinalPrice());

        sc.close();
    }
}