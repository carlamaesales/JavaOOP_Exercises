/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maintravelbooking;

/**
 *
 * @author Carla Mae
 */
import java.util.ArrayList;
import java.util.Scanner;

// Class for managing travel bookings
class TravelBooking {
    // Attributes
    private ArrayList<String> availableFlights;
    private ArrayList<String> availableHotels;
    private ArrayList<String> bookedReservations;

    // Constructor
    public TravelBooking() {
        availableFlights = new ArrayList<>();
        availableHotels = new ArrayList<>();
        bookedReservations = new ArrayList<>();

        availableFlights.add("Flight 101 - Manila to Cebu");
        availableFlights.add("Flight 202 - Manila to Davao");
        availableFlights.add("Flight 303 - Cebu to Bohol");

        availableHotels.add("Hotel Sunshine - Cebu");
        availableHotels.add("Mountain View Resort - Davao");
        availableHotels.add("Beachside Inn - Bohol");
    }

    // Method to search for flights
    public void searchFlights() {
        System.out.println("\n✈️ Available Flights:");
        for (String flight : availableFlights) {
            System.out.println("- " + flight);
        }
    }

    // Method to search for hotels
    public void searchHotels() {
        System.out.println("\n🏨 Available Hotels:");
        for (String hotel : availableHotels) {
            System.out.println("- " + hotel);
        }
    }

    // Method to book a reservation
    public void bookReservation(String reservation) {
        bookedReservations.add(reservation);
        System.out.println("✅ Successfully booked: " + reservation);
    }

    // Method to cancel a reservation
    public void cancelReservation(String reservation) {
        if (bookedReservations.remove(reservation)) {
            System.out.println("❌ Canceled reservation: " + reservation);
        } else {
            System.out.println("⚠️ Reservation not found!");
        }
    }

    // Method to display all booked reservations
    public void viewReservations() {
        System.out.println("\n📋 Your Booked Reservations:");
        if (bookedReservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (String r : bookedReservations) {
                System.out.println("- " + r);
            }
        }
    }
}

public class MainTravelBooking   {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TravelBooking travel = new TravelBooking();
        int choice;

        do {
            System.out.println("\n===== TRAVEL BOOKING SYSTEM =====");
            System.out.println("1. Search Flights");
            System.out.println("2. Search Hotels");
            System.out.println("3. Book a Reservation");
            System.out.println("4. Cancel a Reservation");
            System.out.println("5. View My Reservations");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    travel.searchFlights();
                    break;

                case 2:
                    travel.searchHotels();
                    break;

                case 3:
                    System.out.print("Enter reservation name (e.g., Flight 101 - Manila to Cebu): ");
                    String reservation = input.nextLine();
                    travel.bookReservation(reservation);
                    break;

                case 4:
                    System.out.print("Enter reservation name to cancel: ");
                    String cancel = input.nextLine();
                    travel.cancelReservation(cancel);
                    break;

                case 5:
                    travel.viewReservations();
                    break;

                case 6:
                    System.out.println("✈️ Thank you for using the Travel Booking System! Goodbye!");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Please try again.");
            }
        } while (choice != 6);

        input.close();
    }
}