/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rectangle;

/**
 *
 * @author Carla Mae
 */

   
abstract class Shape {
    // Abstract methods for area and perimeter
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}

// Rectangle class inheriting from Shape
public class Rectangle extends Shape {
    
    // Attributes
    private double width;
    private double height;

    // Constructor to set width and height
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Getter for width
    public double getWidth() {
        return width;
    }

    // Setter for width
    public void setWidth(double width) {
        this.width = width;
    }

    // Getter for height
    public double getHeight() {
        return height;
    }

    // Setter for height
    public void setHeight(double height) {
        this.height = height;
    }

    // Implement abstract method for area
    @Override
    public double calculateArea() {
        return width * height;
    }

    // Implement abstract method for perimeter
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    // Main method
    public static void main(String[] args) {
        // Create a Rectangle instance
        Shape rect = new Rectangle(5.0, 3.0);  // Shape reference to Rectangle object

        // Print width and height using getters
        System.out.println("Width: " + ((Rectangle) rect).getWidth());  
        System.out.println("Height: " + ((Rectangle) rect).getHeight());

        // Calculate and print area and perimeter
        System.out.println("Area: " + rect.calculateArea());
        System.out.println("Perimeter: " + rect.calculatePerimeter());

        // Demonstrate mutability with setters
        ((Rectangle) rect).setWidth(7.0);
        ((Rectangle) rect).setHeight(4.0);
        System.out.println("\nAfter modification:");
        System.out.println("New Area: " + rect.calculateArea());
        System.out.println("New Perimeter: " + rect.calculatePerimeter());
    }
}