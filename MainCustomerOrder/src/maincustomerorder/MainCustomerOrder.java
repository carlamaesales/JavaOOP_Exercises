/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maincustomerorder;

/**
 *
 * @author Carla Mae
 */
import java.util.*;

class CustomerOrder {
    protected String orderID;
    protected String customer;
    protected String orderDate;

    // Constructor
    public CustomerOrder(String orderID, String customer, String orderDate) {
        this.orderID = orderID;
        this.customer = customer;
        this.orderDate = orderDate;
    }

    // Display order details
    public void displayOrderDetails() {
        System.out.println("\n🧾 Order Details:");
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer: " + customer);
        System.out.println("Order Date: " + orderDate);
    }
}

// Subclass: OnlineOrder
class OnlineOrder extends CustomerOrder {
    private String deliveryAddress;
    private String trackingNumber;
    private String trackingStatus;

    // Constructor
    public OnlineOrder(String orderID, String customer, String orderDate, String deliveryAddress, String trackingNumber) {
        super(orderID, customer, orderDate);
        this.deliveryAddress = deliveryAddress;
        this.trackingNumber = trackingNumber;
        this.trackingStatus = "Processing";
    }

    // Method to calculate delivery time
    public int calculateDeliveryTime() {
        if (deliveryAddress.toLowerCase().contains("manila")) {
            return 2;
        } else if (deliveryAddress.toLowerCase().contains("cebu")) {
            return 3;
        } else if (deliveryAddress.toLowerCase().contains("davao")) {
            return 4;
        } else {
            return 5;
        }
    }

    // Method to update tracking status
    public void updateTrackingStatus(String newStatus) {
        this.trackingStatus = newStatus;
        System.out.println("📦 Tracking Status Updated: " + trackingStatus);
    }

    // Override to include more details
    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Current Status: " + trackingStatus);
        System.out.println("Estimated Delivery Time: " + calculateDeliveryTime() + " days");
    }
}

// Main class
public class MainCustomerOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== CUSTOMER ORDER SYSTEM =====");

        // Input order details
        System.out.print("\nEnter Order ID: ");
        String orderID = sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String customer = sc.nextLine();

        System.out.print("Enter Order Date (YYYY-MM-DD): ");
        String orderDate = sc.nextLine();

        System.out.print("Enter Delivery Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Tracking Number: ");
        String trackingNumber = sc.nextLine();

        // Create OnlineOrder object
        OnlineOrder onlineOrder = new OnlineOrder(orderID, customer, orderDate, address, trackingNumber);
        onlineOrder.displayOrderDetails();

        // Update tracking status
        System.out.print("\nEnter new tracking status (Processing, Shipped, Delivered, etc.): ");
        String newStatus = sc.nextLine();
        onlineOrder.updateTrackingStatus(newStatus);

        // Display updated details
        System.out.println("\n===== UPDATED ORDER DETAILS =====");
        onlineOrder.displayOrderDetails();

        sc.close();
    }
}