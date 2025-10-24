/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainevent;

/**
 *
 * @author Carla Mae
 */
import java.util.*;

class Event {
    protected String eventName;
    protected String date;
    protected String location;

    // Constructor
    public Event(String eventName, String date, String location) {
        this.eventName = eventName;
        this.date = date;
        this.location = location;
    }

    // Method to display event details
    public void displayDetails() {
        System.out.println("\n📅 Event Details:");
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + date);
        System.out.println("Location: " + location);
    }

    // Method to check for schedule conflicts
    public boolean hasConflict(Event other) {
        return this.date.equals(other.date) && this.location.equalsIgnoreCase(other.location);
    }
}

// Subclass: Seminar
class Seminar extends Event {
    private int numberOfSpeakers;

    // Constructor
    public Seminar(String eventName, String date, String location, int numberOfSpeakers) {
        super(eventName, date, location);
        this.numberOfSpeakers = numberOfSpeakers;
    }

    // Override display details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Speakers: " + numberOfSpeakers);
    }
}

// Subclass: MusicalPerformance
class MusicalPerformance extends Event {
    private ArrayList<String> performerList;

    // Constructor
    public MusicalPerformance(String eventName, String date, String location, ArrayList<String> performerList) {
        super(eventName, date, location);
        this.performerList = performerList;
    }

    // Override display details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Performers: " + String.join(", ", performerList));
    }
}

// Main class
public class MainEvent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== EVENT MANAGEMENT SYSTEM =====");

        // Create a Seminar
        System.out.print("\nEnter Seminar Name: ");
        String seminarName = sc.nextLine();
        System.out.print("Enter Seminar Date (YYYY-MM-DD): ");
        String seminarDate = sc.nextLine();
        System.out.print("Enter Seminar Location: ");
        String seminarLocation = sc.nextLine();
        System.out.print("Enter Number of Speakers: ");
        int speakers = sc.nextInt();
        sc.nextLine();

        Seminar seminar = new Seminar(seminarName, seminarDate, seminarLocation, speakers);

        // Create a Musical Performance
        System.out.print("\nEnter Musical Performance Name: ");
        String musicName = sc.nextLine();
        System.out.print("Enter Performance Date (YYYY-MM-DD): ");
        String musicDate = sc.nextLine();
        System.out.print("Enter Performance Location: ");
        String musicLocation = sc.nextLine();

        ArrayList<String> performers = new ArrayList<>();
        System.out.print("Enter number of performers: ");
        int numPerformers = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= numPerformers; i++) {
            System.out.print("Enter performer " + i + " name: ");
            performers.add(sc.nextLine());
        }

        MusicalPerformance concert = new MusicalPerformance(musicName, musicDate, musicLocation, performers);

        // Display details
        System.out.println("\n===== EVENT DETAILS =====");
        seminar.displayDetails();
        concert.displayDetails();

        // Check for schedule conflicts
        System.out.println("\n===== SCHEDULE CHECK =====");
        if (seminar.hasConflict(concert)) {
            System.out.println("⚠️ Conflict detected! Both events are on " + seminarDate + " at " + seminarLocation);
        } else {
            System.out.println("✅ No schedule conflicts found.");
        }
    }
}