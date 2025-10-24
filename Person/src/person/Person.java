/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package person;

/**
 *
 * @author Carla Mae
 */
public class Person {

    // Attributes
    private String name;
    private int age;

    // Constructor to set name and age
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to get name
    public String getName() {
        return name;
    }

    // Method to get age
    public int getAge() {
        return age;
    }

    // Main method to create instances and print details
    public static void main(String[] args) {
        // Create two instances of Person
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 30);

        // Print their name and age
        System.out.println("Person 1: Name = " + person1.getName() + ", Age = " + person1.getAge());
        System.out.println("Person 2: Name = " + person2.getName() + ", Age = " + person2.getAge());
    }
}