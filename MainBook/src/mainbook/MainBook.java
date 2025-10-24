/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainbook;

/**
 *
 * @author Carla Mae
 */
import java.util.ArrayList;
import java.util.Scanner;

// Book class
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

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Display book details
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
    }
}

// Library class
class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // Method to add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added successfully!");
    }

    // Method to remove a book by ISBN
    public void removeBook(String isbn) {
        boolean removed = false;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                System.out.println("❌ Book removed successfully!");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("⚠️ Book not found with ISBN: " + isbn);
        }
    }

    // Display all books
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("📭 No books in the collection.");
        } else {
            System.out.println("\n📚 Book Collection:");
            for (Book book : books) {
                book.displayBook();
            }
        }
    }
}

// Main class
public class MainBook {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== LIBRARY MENU ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = input.nextLine();
                    System.out.print("Enter Author: ");
                    String author = input.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = input.nextLine();

                    Book newBook = new Book(title, author, isbn);
                    library.addBook(newBook);
                    break;

                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String removeIsbn = input.nextLine();
                    library.removeBook(removeIsbn);
                    break;

                case 3:
                    library.displayAllBooks();
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
