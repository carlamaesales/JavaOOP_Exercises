/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maintrafficlight;

/**
 *
 * @author Carla Mae
 */
import java.util.Scanner;

// TrafficLight class
class TrafficLight {
    private String color;
    private int duration;

    // Constructor
    public TrafficLight(String color, int duration) {
        this.color = color;
        this.duration = duration;
    }

    // Getters and Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Method to change the color
    public void changeColor(String newColor, int newDuration) {
        this.color = newColor;
        this.duration = newDuration;
        System.out.println("🚦 Traffic light changed to " + color + " for " + duration + " seconds.");
    }

    // Check if light is red
    public boolean isRed() {
        return color.equalsIgnoreCase("red");
    }

    // Check if light is green
    public boolean isGreen() {
        return color.equalsIgnoreCase("green");
    }

    // Display current traffic light state
    public void displayLight() {
        System.out.println("Current Light: " + color + " (" + duration + " seconds)");
    }
}

// Main class
public class MainTrafficLight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create a TrafficLight object
        System.out.print("Enter initial color (red/yellow/green): ");
        String color = input.nextLine();
        System.out.print("Enter duration in seconds: ");
        int duration = input.nextInt();
        input.nextLine();

        TrafficLight light = new TrafficLight(color, duration);

        int choice;
        do {
            System.out.println("\n=== TRAFFIC LIGHT MENU ===");
            System.out.println("1. Display Light");
            System.out.println("2. Change Color");
            System.out.println("3. Check if Red");
            System.out.println("4. Check if Green");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); 
            
            switch (choice) {
                case 1:
                    light.displayLight();
                    break;

                case 2:
                    System.out.print("Enter new color: ");
                    String newColor = input.nextLine();
                    System.out.print("Enter new duration: ");
                    int newDuration = input.nextInt();
                    light.changeColor(newColor, newDuration);
                    break;

                case 3:
                    if (light.isRed())
                        System.out.println("🟥 Stop! The light is RED.");
                    else
                        System.out.println("✅ The light is not red.");
                    break;

                case 4:
                    if (light.isGreen())
                        System.out.println("🟩 Go! The light is GREEN.");
                    else
                        System.out.println("🚫 The light is not green.");
                    break;

                case 5:
                    System.out.println("👋 Exiting program...");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again!");
            }

        } while (choice != 5);

        input.close();
    }
}