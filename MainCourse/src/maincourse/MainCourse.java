/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maincourse;

/**
 *
 * @author Carla Mae
 */
import java.util.Scanner;

class Course {
    // Attributes
    protected String courseName;
    protected String instructor;
    protected int credits;

    // Constructor
    public Course(String courseName, String instructor, int credits) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
    }

    // Method to display course details
    public void displayDetails() {
        System.out.println("\n📘 Course Details:");
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Credits: " + credits);
    }
}

// Subclass: OnlineCourse
class OnlineCourse extends Course {
    private String platform;
    private int duration;

    // Constructor
    public OnlineCourse(String courseName, String instructor, int credits, String platform, int duration) {
        super(courseName, instructor, credits);
        this.platform = platform;
        this.duration = duration;
    }

    // Override display method
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Duration: " + duration + " weeks");
    }

    // Method to check certificate eligibility
    public void checkCertificateEligibility() {
        if (duration >= 4) {
            System.out.println("🏅 Eligible for Certificate!");
        } else {
            System.out.println("❌ Not eligible for Certificate (minimum 4 weeks required).");
        }
    }
}

// Main class
public class MainCourse{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== COURSE MANAGEMENT SYSTEM =====");

        // Get details from user
        System.out.print("Enter course name: ");
        String name = sc.nextLine();

        System.out.print("Enter instructor name: ");
        String instructor = sc.nextLine();

        System.out.print("Enter number of credits: ");
        int credits = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter platform (e.g., Coursera, Udemy): ");
        String platform = sc.nextLine();

        System.out.print("Enter duration (weeks): ");
        int duration = sc.nextInt();

        // Create OnlineCourse object
        OnlineCourse onlineCourse = new OnlineCourse(name, instructor, credits, platform, duration);
        onlineCourse.displayDetails();
        onlineCourse.checkCertificateEligibility();

        sc.close();
    }
}