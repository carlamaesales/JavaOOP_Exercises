/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainshape;

/**
 *
 * @author Carla Mae
 */
import java.util.Scanner;

// Abstract class Shape
abstract class Shape {
    // Abstract methods
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}

// Rectangle subclass
class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implement abstract methods
    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Circle subclass
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implement abstract methods
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Triangle subclass
class Triangle extends Shape {
    private double side1, side2, side3;

    // Constructor
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Implement abstract methods
    @Override
    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

public class MainShape {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== SHAPE CALCULATOR =====");
            System.out.println("1. Rectangle");
            System.out.println("2. Circle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Choose a shape: ");
            choice = input.nextInt();

            Shape shape = null;

            switch (choice) {
                case 1:
                    System.out.print("Enter length: ");
                    double length = input.nextDouble();
                    System.out.print("Enter width: ");
                    double width = input.nextDouble();
                    shape = new Rectangle(length, width);
                    break;

                case 2:
                    System.out.print("Enter radius: ");
                    double radius = input.nextDouble();
                    shape = new Circle(radius);
                    break;

                case 3:
                    System.out.print("Enter side 1: ");
                    double side1 = input.nextDouble();
                    System.out.print("Enter side 2: ");
                    double side2 = input.nextDouble();
                    System.out.print("Enter side 3: ");
                    double side3 = input.nextDouble();
                    shape = new Triangle(side1, side2, side3);
                    break;

                case 4:
                    System.out.println("Exiting program... 🎨 Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

            if (shape != null) {
                System.out.println("\n📏 Area: " + shape.calculateArea());
                System.out.println("📐 Perimeter: " + shape.calculatePerimeter());
            }

        } while (choice != 4);

        input.close();
    }
}