/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maincustomer;

/**
 *
 * @author Carla Mae
 */
import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    // Attributes
    private String name;
    private String email;
    protected ArrayList<Double> purchaseHistory;

    // Constructor
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.purchaseHistory = new ArrayList<>();
    }

    // Method to add a purchase
    public void addPurchase(double amount) {
        if (amount > 0) {
            purchaseHistory.add(amount);
            System.out.println("✅ Purchase of ₱" + amount + " added for " + name);
        } else {
            System.out.println("⚠️ Invalid purchase amount!");
        }
    }

    // Method to calculate total expenditure
    public double getTotalExpenditure() {
        double total = 0;
        for (double amount : purchaseHistory) {
            total += amount;
        }
        return total;
    }

    // Method to display customer details
    public void displayCustomerInfo() {
        System.out.println("\n👤 Customer Information:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Total Expenditure: ₱" + getTotalExpenditure());
    }
}

// Subclass: LoyalCustomer
class LoyalCustomer extends Customer {
    private double discountRate;

    // Constructor
    public LoyalCustomer(String name, String email, double discountRate) {
        super(name, email);
        this.discountRate = discountRate;
    }

    // Method to apply discount on a new purchase
    public void addDiscountedPurchase(double amount) {
        if (amount > 0) {
            double discountedAmount = amount - (amount * discountRate);
            purchaseHistory.add(discountedAmount);
            System.out.println("✅ Purchase added with " + (discountRate * 100) + "% discount. Final amount: ₱" + discountedAmount);
        } else {
            System.out.println("⚠️ Invalid purchase amount!");
        }
    }

    // Override display method
    @Override
    public void displayCustomerInfo() {
        System.out.println("\n🌟 Loyal Customer Information:");
        System.out.println("Discount Rate: " + (discountRate * 100) + "%");
        System.out.println("Total Expenditure (after discounts): ₱" + getTotalExpenditure());
    }
}

// Main program
public class MainCustomer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        Customer regularCustomer = new Customer("Juan Dela Cruz", "juan@gmail.com");
        LoyalCustomer loyalCustomer = new LoyalCustomer("Maria Santos", "maria@gmail.com", 0.10);

        do {
            System.out.println("\n===== CUSTOMER MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Purchase (Regular Customer)");
            System.out.println("2. Add Discounted Purchase (Loyal Customer)");
            System.out.println("3. View Regular Customer Info");
            System.out.println("4. View Loyal Customer Info");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter purchase amount: ₱");
                    double amount1 = sc.nextDouble();
                    regularCustomer.addPurchase(amount1);
                    break;

                case 2:
                    System.out.print("Enter purchase amount: ₱");
                    double amount2 = sc.nextDouble();
                    loyalCustomer.addDiscountedPurchase(amount2);
                    break;

                case 3:
                    regularCustomer.displayCustomerInfo();
                    break;

                case 4:
                    loyalCustomer.displayCustomerInfo();
                    break;

                case 5:
                    System.out.println("👋 Exiting program... Thank you!");
                    break;

                default:
                    System.out.println("⚠️ Invalid option! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}