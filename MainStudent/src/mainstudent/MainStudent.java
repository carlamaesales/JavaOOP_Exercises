/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainstudent;

/**
 *
 * @author Carla Mae
 */
import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    private String name;
    private String grade;
    private ArrayList<String> courses;

    // Constructor
    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
        this.courses = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    // Method to add a course
    public void addCourse(String course) {
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println("✅ Course \"" + course + "\" added successfully.");
        } else {
            System.out.println("⚠️ Student is already enrolled in \"" + course + "\".");
        }
    }

    // Method to remove a course
    public void removeCourse(String course) {
        if (courses.contains(course)) {
            courses.remove(course);
            System.out.println("❌ Course \"" + course + "\" removed successfully.");
        } else {
            System.out.println("⚠️ Course \"" + course + "\" not found.");
        }
    }

    // Display student information
    public void displayStudentInfo() {
        System.out.println("\n👩‍🎓 Student Information:");
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        if (courses.isEmpty()) {
            System.out.println("Courses: None enrolled yet.");
        } else {
            System.out.println("Courses: " + courses);
        }
    }
}

// Main class
public class MainStudent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== STUDENT COURSE MANAGEMENT SYSTEM ===");
        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter student grade: ");
        String grade = input.nextLine();

        // Create Student object
        Student student = new Student(name, grade);

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. Display Student Info");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter course name to add: ");
                    String addCourse = input.nextLine();
                    student.addCourse(addCourse);
                    break;

                case 2:
                    System.out.print("Enter course name to remove: ");
                    String removeCourse = input.nextLine();
                    student.removeCourse(removeCourse);
                    break;

                case 3:
                    student.displayStudentInfo();
                    break;

                case 4:
                    System.out.println("👋 Exiting program...");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 4);

        input.close();
    }
}