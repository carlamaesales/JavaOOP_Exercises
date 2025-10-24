/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainmovie;

/**
 *
 * @author Carla Mae
 */
import java.util.ArrayList;
import java.util.Scanner;

class Movie {
    // Attributes
    private String title;
    private String director;
    private ArrayList<String> actors;
    private ArrayList<String> reviews;

    // Constructor
    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
        this.actors = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    // Method to add actor
    public void addActor(String actor) {
        actors.add(actor);
    }

    // Method to add review
    public void addReview(String review) {
        reviews.add(review);
    }

    // Method to display movie details
    public void displayDetails() {
        System.out.println("\n🎬 Movie Title: " + title);
        System.out.println("🎥 Director: " + director);
        System.out.println("👨‍🎤 Actors: " + (actors.isEmpty() ? "No actors added." : actors));
        System.out.println("⭐ Reviews: " + (reviews.isEmpty() ? "No reviews yet." : reviews));
    }

    // Method to get all reviews
    public void getAllReviews() {
        if (reviews.isEmpty()) {
            System.out.println("No reviews available for this movie yet.");
        } else {
            System.out.println("\nAll Reviews for " + title + ":");
            for (String r : reviews) {
                System.out.println("- " + r);
            }
        }
    }
}

public class MainMovie {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create movie object
        System.out.print("Enter movie title: ");
        String title = input.nextLine();
        System.out.print("Enter director name: ");
        String director = input.nextLine();
        Movie movie = new Movie(title, director);

        int choice;
        do {
            System.out.println("\n===== MOVIE MENU =====");
            System.out.println("1. Add Actor");
            System.out.println("2. Add Review");
            System.out.println("3. View All Reviews");
            System.out.println("4. Show Movie Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter actor name: ");
                    String actor = input.nextLine();
                    movie.addActor(actor);
                    System.out.println("✅ Actor added successfully!");
                    break;

                case 2:
                    System.out.print("Enter your review: ");
                    String review = input.nextLine();
                    movie.addReview(review);
                    System.out.println("✅ Review added successfully!");
                    break;

                case 3:
                    movie.getAllReviews();
                    break;

                case 4:
                    movie.displayDetails();
                    break;

                case 5:
                    System.out.println("🎬 Exiting program... Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }

        } while (choice != 5);

        input.close();
    }
}