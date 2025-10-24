/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainmusiclibrary;

/**
 *
 * @author Carla Mae
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class MusicLibrary {
    private ArrayList<String> songs;

    // Constructor
    public MusicLibrary() {
        songs = new ArrayList<>();
    }

    // Method to add a song
    public void addSong(String song) {
        songs.add(song);
        System.out.println("🎶 Song added: " + song);
    }

    // Method to remove a song
    public void removeSong(String song) {
        if (songs.remove(song)) {
            System.out.println("❌ Song removed: " + song);
        } else {
            System.out.println("⚠️ Song not found: " + song);
        }
    }

    // Method to play a random song
    public void playRandomSong() {
        if (songs.isEmpty()) {
            System.out.println("🎧 No songs in the library to play.");
        } else {
            Random random = new Random();
            String song = songs.get(random.nextInt(songs.size()));
            System.out.println("🎵 Now playing: " + song);
        }
    }

    // Display all songs
    public void displaySongs() {
        System.out.println("\n🎼 MUSIC LIBRARY:");
        if (songs.isEmpty()) {
            System.out.println("No songs available.");
        } else {
            for (String song : songs) {
                System.out.println("- " + song);
            }
        }
    }
}

public class MainMusicLibrary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MusicLibrary library = new MusicLibrary();
        int choice;

        do {
            System.out.println("\n===== MUSIC LIBRARY MENU =====");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. View All Songs");
            System.out.println("4. Play Random Song");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String songToAdd = input.nextLine();
                    library.addSong(songToAdd);
                    break;

                case 2:
                    System.out.print("Enter song title to remove: ");
                    String songToRemove = input.nextLine();
                    library.removeSong(songToRemove);
                    break;

                case 3:
                    library.displaySongs();
                    break;

                case 4:
                    library.playRandomSong();
                    break;

                case 5:
                    System.out.println("Exiting Music Library... 🎧 Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        } while (choice != 5);

        input.close();
    }
}