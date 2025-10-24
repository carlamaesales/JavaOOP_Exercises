/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maininventory;

/**
 *
 * @author Carla Mae
 */
import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private int quantity;
    private double price;

    // Constructor
    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Method to reduce quantity
    public void reduceQuantity(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
        } else {
            System.out.println("⚠️ Not enough stock for " + name);
        }
    }

    @Override
    public String toString() {
        return "Product: " + name + " | Quantity: " + quantity + " | Price: ₱" + price;
    }
}

class Inventory {
    private ArrayList<Product> products = new ArrayList<>();

    // Add product
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("✅ " + product.getName() + " has been added to inventory.");
    }

    // Remove product by name
    public void removeProduct(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                products.remove(p);
                System.out.println("❌ " + name + " has been removed from inventory.");
                return;
            }
        }
        System.out.println("⚠️ Product not found: " + name);
    }

    // Display all products
    public void displayProducts() {
        System.out.println("\n📦 INVENTORY LIST:");
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }

    // Check for low inventory
    public void checkLowInventory(int threshold) {
        System.out.println("\n⚠️ LOW INVENTORY PRODUCTS (Below " + threshold + "):");
        boolean found = false;
        for (Product p : products) {
            if (p.getQuantity() < threshold) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("All products are sufficiently stocked.");
        }
    }
}

public class MainInventory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
            System.out.println("\n===== INVENTORY MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View All Products");
            System.out.println("4. Check Low Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = input.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = input.nextInt();
                    System.out.print("Enter price: ");
                    double price = input.nextDouble();
                    Product newProduct = new Product(name, quantity, price);
                    inventory.addProduct(newProduct);
                    break;

                case 2:
                    System.out.print("Enter product name to remove: ");
                    String removeName = input.nextLine();
                    inventory.removeProduct(removeName);
                    break;

                case 3:
                    inventory.displayProducts();
                    break;

                case 4:
                    System.out.print("Enter low stock threshold: ");
                    int threshold = input.nextInt();
                    inventory.checkLowInventory(threshold);
                    break;

                case 5:
                    System.out.println("Exiting system... 🏁");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        input.close();
    }
}