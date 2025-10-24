/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainairplane;

/**
 *
 * @author Carla Mae
 */
import java.util.Scanner;

class Airplane {
    private String flightNumber;
    private String destination;
    private String departureTime;
    private boolean delayed;

    // Constructor
    public Airplane(String flightNumber, String destination, String departureTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.delayed = false;
    }

    // Method to check flight status
    public void checkStatus() {
        if (delayed) {
            System.out.println("✈️ Flight " + flightNumber + " to " + destination + " is delayed.");
        } else {
            System.out.println("✅ Flight " + flightNumber + " to " + destination + " is on time.");
        }
    }

    // Method to delay the flight
    public void delayFlight() {
        delayed = true;
        System.out.println("⚠️ Flight " + flightNumber + " has been marked as delayed.");
    }

    // Method to update departure time
    public void updateDepartureTime(String newTime) {
        departureTime = newTime;
        System.out.println("🕒 Departure time updated to: " + departureTime);
    }

    // Method to display flight info
    public void displayInfo() {
        System.out.println("\n--- Flight Information ---");
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Destination: " + destination);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Status: " + (delayed ? "Delayed" : "On Time"));
    }
}

public class MainAirplane {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== AIRPLANE FLIGHT MANAGEMENT ===");

        System.out.print("Enter Flight Number: ");
        String flightNum = input.nextLine();
        System.out.print("Enter Destination: ");
        String destination = input.nextLine();
        System.out.print("Enter Departure Time: ");
        String departure = input.nextLine();

        Airplane flight = new Airplane(flightNum, destination, departure);

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Check Flight Status");
            System.out.println("2. Delay Flight");
            System.out.println("3. Update Departure Time");
            System.out.println("4. Display Flight Information");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    flight.checkStatus();
                    break;
                case 2:
                    flight.delayFlight();
                    break;
                case 3:
                    System.out.print("Enter new departure time: ");
                    String newTime = input.nextLine();
                    flight.updateDepartureTime(newTime);
                    break;
                case 4:
                    flight.displayInfo();
                    break;
                case 5:
                    System.out.println("Exiting system... ✈️ Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);

        input.close();
    }
}