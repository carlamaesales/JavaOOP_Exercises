/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainschool;

/**
 *
 * @author Carla Mae
 */
import java.util.ArrayList;
import java.util.Scanner;

class School {
    private ArrayList<String> students;
    private ArrayList<String> teachers;
    private ArrayList<String> classes;

    // Constructor
    public School() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        classes = new ArrayList<>();
    }

    // Add a student
    public void addStudent(String studentName) {
        students.add(studentName);
        System.out.println("✅ Student added: " + studentName);
    }

    // Remove a student
    public void removeStudent(String studentName) {
        if (students.remove(studentName)) {
            System.out.println("❌ Student removed: " + studentName);
        } else {
            System.out.println("⚠️ Student not found: " + studentName);
        }
    }

    // Add a teacher
    public void addTeacher(String teacherName) {
        teachers.add(teacherName);
        System.out.println("✅ Teacher added: " + teacherName);
    }

    // Remove a teacher
    public void removeTeacher(String teacherName) {
        if (teachers.remove(teacherName)) {
            System.out.println("❌ Teacher removed: " + teacherName);
        } else {
            System.out.println("⚠️ Teacher not found: " + teacherName);
        }
    }

    // Create a new class
    public void createClass(String className) {
        classes.add(className);
        System.out.println("🏫 Class created: " + className);
    }

    // Display all students
    public void displayStudents() {
        System.out.println("\n👩‍🎓 STUDENTS:");
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (String s : students) {
                System.out.println("- " + s);
            }
        }
    }

    // Display all teachers
    public void displayTeachers() {
        System.out.println("\n👨‍🏫 TEACHERS:");
        if (teachers.isEmpty()) {
            System.out.println("No teachers employed.");
        } else {
            for (String t : teachers) {
                System.out.println("- " + t);
            }
        }
    }

    // Display all classes
    public void displayClasses() {
        System.out.println("\n🏫 CLASSES:");
        if (classes.isEmpty()) {
            System.out.println("No classes created yet.");
        } else {
            for (String c : classes) {
                System.out.println("- " + c);
            }
        }
    }
}

public class MainSchool {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        School school = new School();
        int choice;

        do {
            System.out.println("\n===== SCHOOL MANAGEMENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Add Teacher");
            System.out.println("4. Remove Teacher");
            System.out.println("5. Create Class");
            System.out.println("6. View All Students");
            System.out.println("7. View All Teachers");
            System.out.println("8. View All Classes");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String student = input.nextLine();
                    school.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter student name to remove: ");
                    String removeStudent = input.nextLine();
                    school.removeStudent(removeStudent);
                    break;

                case 3:
                    System.out.print("Enter teacher name: ");
                    String teacher = input.nextLine();
                    school.addTeacher(teacher);
                    break;

                case 4:
                    System.out.print("Enter teacher name to remove: ");
                    String removeTeacher = input.nextLine();
                    school.removeTeacher(removeTeacher);
                    break;

                case 5:
                    System.out.print("Enter class name: ");
                    String className = input.nextLine();
                    school.createClass(className);
                    break;

                case 6:
                    school.displayStudents();
                    break;

                case 7:
                    school.displayTeachers();
                    break;

                case 8:
                    school.displayClasses();
                    break;

                case 9:
                    System.out.println("Exiting system... 🏫 Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 9);

        input.close();
    }
}