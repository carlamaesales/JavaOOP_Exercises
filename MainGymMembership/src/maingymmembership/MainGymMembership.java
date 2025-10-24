/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maingymmembership;

/**
 *
 * @author Carla Mae
 */
import java.util.*;

class GymMembership {
    protected String memberName;
    protected String membershipType; 
    protected int duration;

    // Constructor
    public GymMembership(String memberName, String membershipType, int duration) {
        this.memberName = memberName;
        this.membershipType = membershipType;
        this.duration = duration;
    }

    // Method to calculate membership fees
    public double calculateFees() {
        double rate;
        if (membershipType.equalsIgnoreCase("Basic")) {
            rate = 500; 
        } else if (membershipType.equalsIgnoreCase("Standard")) {
            rate = 800; 
        } else {
            rate = 1000;
        }
        return rate * duration;
    }

    // Method to check for special offers
    public void checkSpecialOffers() {
        if (duration >= 12) {
            System.out.println("🎉 Special Offer: 10% discount for 1-year membership!");
        } else {
            System.out.println("No special offers available for this duration.");
        }
    }

    // Display membership details
    public void displayDetails() {
        System.out.println("\n💪 Gym Membership Details:");
        System.out.println("Member Name: " + memberName);
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Total Fees: ₱" + calculateFees());
    }
}

// Subclass: PremiumMembership
class PremiumMembership extends GymMembership {
    private boolean personalTrainer;
    private boolean spaAccess;

    // Constructor
    public PremiumMembership(String memberName, String membershipType, int duration, boolean personalTrainer, boolean spaAccess) {
        super(memberName, membershipType, duration);
        this.personalTrainer = personalTrainer;
        this.spaAccess = spaAccess;
    }

    // Override calculateFees to include extra charges
    @Override
    public double calculateFees() {
        double baseFee = super.calculateFees();
        if (personalTrainer) {
            baseFee += 1000 * duration;
        }
        if (spaAccess) {
            baseFee += 500 * duration;
        }
        return baseFee;
    }

    // Override display method
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Personal Trainer: " + (personalTrainer ? "Yes" : "No"));
        System.out.println("Spa Access: " + (spaAccess ? "Yes" : "No"));
        System.out.println("Updated Total Fees: ₱" + calculateFees());
    }

    // Override special offer check for premium members
    @Override
    public void checkSpecialOffers() {
        if (duration >= 6) {
            System.out.println("🌟 Premium Offer: Free 1-month extension for memberships 6 months or longer!");
        } else {
            System.out.println("No premium offers available for this duration.");
        }
    }
}

// Main class
public class MainGymMembership {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== GYM MEMBERSHIP SYSTEM =====");
        System.out.println("1. Regular Membership");
        System.out.println("2. Premium Membership");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("\nEnter Member Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Membership Type (Basic/Standard): ");
        String type = sc.nextLine();

        System.out.print("Enter Duration (in months): ");
        int months = sc.nextInt();

        if (choice == 1) {
            GymMembership gm = new GymMembership(name, type, months);
            gm.displayDetails();
            gm.checkSpecialOffers();

        } else if (choice == 2) {
            System.out.print("Include Personal Trainer? (true/false): ");
            boolean trainer = sc.nextBoolean();

            System.out.print("Include Spa Access? (true/false): ");
            boolean spa = sc.nextBoolean();

            PremiumMembership pm = new PremiumMembership(name, type, months, trainer, spa);
            pm.displayDetails();
            pm.checkSpecialOffers();

        } else {
            System.out.println("❌ Invalid choice.");
        }

        sc.close();
    }
}