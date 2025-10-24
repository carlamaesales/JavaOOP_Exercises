/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainlibrary;

/**
 *
 * @author Carla Mae
 */
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Author: " + author + " | ISBN: " + isbn;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added: " + book.getTitle());
    }

    public void removeBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("❌ Book removed: " + title);
                return;
            }
        }
        System.out.println("⚠️ Book not found: " + title);
    }

    public void displayBooks() {
        System.out.println("\n📚 Library Books:");
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

public class MainLibrary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View All Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = input.nextLine();
                    System.out.print("Enter author: ");
                    String author = input.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = input.nextLine();
                    Book newBook = new Book(title, author, isbn);
                    library.addBook(newBook);
                    break;

                case 2:
                    System.out.print("Enter title of the book to remove: ");
                    String removeTitle = input.nextLine();
                    library.removeBook(removeTitle);
                    break;

                case 3:
                    library.displayBooks();
                    break;

                case 4:
                    System.out.println("Exiting program... 👋");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 4);

        input.close();
    }
}