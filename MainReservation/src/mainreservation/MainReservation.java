/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainreservation;

/**
 *
 * @author Carla Mae
 */
import java.util.*;

class Reservation {
    protected String reservationID;
    protected String customerName;
    protected String date;
    protected String status;

    // Constructor
    public Reservation(String reservationID, String customerName, String date) {
        this.reservationID = reservationID;
        this.customerName = customerName;
        this.date = date;
        this.status = "Confirmed";
    }

    // Method to check reservation status
    public void checkStatus() {
        System.out.println("📅 Reservation Status: " + status);
    }

    // Method to modify reservation details
    public void modifyDetails(String newDate) {
        this.date = newDate;
        System.out.println("✅ Reservation date updated to: " + date);
    }

    // Display reservation info
    public void displayDetails() {
        System.out.println("\n🔹 Reservation Details:");
        System.out.println("Reservation ID: " + reservationID);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Date: " + date);
        System.out.println("Status: " + status);
    }
}

// Subclass: ResortReservation
class ResortReservation extends Reservation {
    private int roomNumber;

    public ResortReservation(String reservationID, String customerName, String date, int roomNumber) {
        super(reservationID, customerName, date);
        this.roomNumber = roomNumber;
    }

    // Override display method
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Room Number: " + roomNumber);
    }

    // Modify room number
    public void modifyRoom(int newRoomNumber) {
        this.roomNumber = newRoomNumber;
        System.out.println("🏨 Room number updated to: " + roomNumber);
    }
}

// Subclass: RailwayReservation
class RailwayReservation extends Reservation {
    private String seatNumber;

    public RailwayReservation(String reservationID, String customerName, String date, String seatNumber) {
        super(reservationID, customerName, date);
        this.seatNumber = seatNumber;
    }

    // Override display method
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Seat Number: " + seatNumber);
    }

    // Modify seat number
    public void modifySeat(String newSeatNumber) {
        this.seatNumber = newSeatNumber;
        System.out.println("🚆 Seat number updated to: " + seatNumber);
    }
}

// Main class
public class MainReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== RESERVATION SYSTEM =====");
        System.out.println("1. Resort Reservation");
        System.out.println("2. Railway Reservation");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("\nEnter Reservation ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter Room Number: ");
            int room = sc.nextInt();
            ResortReservation resort = new ResortReservation(id, name, date, room);

            resort.displayDetails();
            resort.checkStatus();

            System.out.print("\nEnter new date to modify: ");
            sc.nextLine();
            String newDate = sc.nextLine();
            resort.modifyDetails(newDate);

            System.out.print("Enter new room number: ");
            int newRoom = sc.nextInt();
            resort.modifyRoom(newRoom);

            resort.displayDetails();

        } else if (choice == 2) {
            System.out.print("Enter Seat Number: ");
            String seat = sc.nextLine();
            RailwayReservation railway = new RailwayReservation(id, name, date, seat);

            railway.displayDetails();
            railway.checkStatus();

            System.out.print("\nEnter new date to modify: ");
            String newDate = sc.nextLine();
            railway.modifyDetails(newDate);

            System.out.print("Enter new seat number: ");
            String newSeat = sc.nextLine();
            railway.modifySeat(newSeat);

            railway.displayDetails();
        } else {
            System.out.println("❌ Invalid choice.");
        }

        sc.close();
    }
}