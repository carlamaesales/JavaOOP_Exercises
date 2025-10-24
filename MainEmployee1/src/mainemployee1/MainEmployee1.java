/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainemployee1;

/**
 *
 * @author Carla Mae
 */
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

// Employee class
class Employee {
    private String name;
    private double salary;
    private LocalDate hireDate;

    // Constructor
    public Employee(String name, double salary, LocalDate hireDate) {
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    // Method to calculate years of service
    public int calculateYearsOfService() {
        LocalDate currentDate = LocalDate.now();
        if ((hireDate != null) && (currentDate.isAfter(hireDate))) {
            Period period = Period.between(hireDate, currentDate);
            return period.getYears();
        } else {
            return 0;
        }
    }

    // Display employee details
    public void displayEmployeeInfo() {
        System.out.println("\n👤 Employee Information:");
        System.out.println("Name: " + name);
        System.out.println("Salary: ₱" + salary);
        System.out.println("Hire Date: " + hireDate);
        System.out.println("Years of Service: " + calculateYearsOfService() + " years");
    }
}

// Main class
public class MainEmployee1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== EMPLOYEE SERVICE CALCULATOR ===");
        System.out.print("Enter employee name: ");
        String name = input.nextLine();

        System.out.print("Enter employee salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter hire year (YYYY): ");
        int year = input.nextInt();

        System.out.print("Enter hire month (1-12): ");
        int month = input.nextInt();

        System.out.print("Enter hire day (1-31): ");
        int day = input.nextInt();

        // Create a LocalDate object for hire date
        LocalDate hireDate = LocalDate.of(year, month, day);

        // Create Employee object
        Employee emp = new Employee(name, salary, hireDate);

        // Display employee details
        emp.displayEmployeeInfo();

        input.close();
    }
}