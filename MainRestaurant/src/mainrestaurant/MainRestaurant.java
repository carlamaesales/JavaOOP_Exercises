/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainrestaurant;

/**
 *
 * @author Carla Mae
 */
import java.util.ArrayList;
import java.util.Scanner;

class Restaurant {
    // Attributes
    private ArrayList<String> menuItems;
    private ArrayList<Double> prices;
    private ArrayList<Integer> ratings;

    // Constructor
    public Restaurant() {
        menuItems = new ArrayList<>();
        prices = new ArrayList<>();
        ratings = new ArrayList<>();
    }

    // Method to add a menu item
    public void addItem(String item, double price) {
        menuItems.add(item);
        prices.add(price);
        System.out.println("✅ " + item + " added to the menu.");
    }

    // Method to remove a menu item
    public void removeItem(String item) {
        int index = menuItems.indexOf(item);
        if (index != -1) {
            menuItems.remove(index);
            prices.remove(index);
            System.out.println("❌ " + item + " removed from the menu.");
        } else {
            System.out.println("Item not found in the menu.");
        }
    }

    // Method to rate the restaurant
    public void addRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            System.out.println("⭐ Thank you for rating: " + rating);
        } else {
            System.out.println("⚠️ Please enter a rating between 1 and 5.");
        }
    }

    // Method to calculate average rating
    public double calculateAverageRating() {
        if (ratings.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (int rate : ratings) {
            sum += rate;
        }
        return sum / ratings.size();
    }

    // Method to display menu
    public void displayMenu() {
        System.out.println("\n🍴 MENU ITEMS:");
        if (menuItems.isEmpty()) {
            System.out.println("No items available.");
        } else {
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println("- " + menuItems.get(i) + " : ₱" + prices.get(i));
            }
        }
    }

    // Method to display restaurant summary
    public void displayRestaurantInfo() {
        System.out.println("\n===== RESTAURANT SUMMARY =====");
        displayMenu();
        double avgRating = calculateAverageRating();
        if (avgRating > 0)
            System.out.println("⭐ Average Rating: " + String.format("%.2f", avgRating));
        else
            System.out.println("⭐ No ratings yet.");
    }
}

public class MainRestaurant {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        int choice;
        do {
            System.out.println("\n===== RESTAURANT MENU SYSTEM =====");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Remove Menu Item");
            System.out.println("3. View Menu");
            System.out.println("4. Add Rating");
            System.out.println("5. View Average Rating");
            System.out.println("6. View Restaurant Summary");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String item = input.nextLine();
                    System.out.print("Enter price: ₱");
                    double price = input.nextDouble();
                    restaurant.addItem(item, price);
                    break;

                case 2:
                    System.out.print("Enter item name to remove: ");
                    String removeItem = input.nextLine();
                    restaurant.removeItem(removeItem);
                    break;

                case 3:
                    restaurant.displayMenu();
                    break;

                case 4:
                    System.out.print("Enter rating (1-5): ");
                    int rating = input.nextInt();
                    restaurant.addRating(rating);
                    break;

                case 5:
                    double avg = restaurant.calculateAverageRating();
                    if (avg == 0)
                        System.out.println("No ratings yet.");
                    else
                        System.out.println("⭐ Average Rating: " + String.format("%.2f", avg));
                    break;

                case 6:
                    restaurant.displayRestaurantInfo();
                    break;

                case 7:
                    System.out.println("👋 Exiting program... Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 7);

        input.close();
    }
}