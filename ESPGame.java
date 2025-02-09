/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The user is able to pick from four options, in order to see if they can correctly guess
 * the colors out of 16, 10 or 5, which are read from a text file. They are able to continue playing, 
 * until they say no, or enter the 4th  option, which will ask for their name, a description about 
 * themselves, and the due date of the project. It then writes the results of the previous guessing
 * game, and everything else to a file.
 * Due: 02/10/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not 
 * copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Jonathan Herrera
*/

import java.util.Scanner;
import java.util.*; // Wild Card
import java.io.*; // Import io package for File I/O

public class ESPGame {
    // Constants for file names and menu options
    private static final String FILE_NAME = "colors.txt";
    private static final String OUTPUT_FILE = "EspGameResults.txt";
    private static final String MENU = "A. Read and display the first 16 colors from the colors.txt file\n" +
                                       "B. Read and display the first 10 colors from the colors.txt file\n" +
                                       "C. Read and display the first 5 colors from the colors.txt file\n" +
                                       "D. Exit\n";
    private static final int MAX_GUESSES = 3; // Number of guesses allowed

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        // Variables to store game results
        int correctGuesses = 0;
        boolean gamePlayed = false; // Track if a game has been played

        while (true) { // Loop to allow playing multiple games
            System.out.println("CMSC203 Assignment 1.\n");
            System.out.println("Welcome to ESP - Extrasensory Perception!\n");
            System.out.println("Please pick one of the 4 following options: \n");
            System.out.print(MENU);
            System.out.print("Enter your option: ");
            char choice = scan.nextLine().toLowerCase().charAt(0);

            int colorCount = 0;
            switch (choice) {
                case 'a':
                    colorCount = 16;
                    break;
                case 'b':
                    colorCount = 10;
                    break;
                case 'c':
                    colorCount = 5;
                    break;
                case 'd':
                    // Prompt for user information only when exiting
                    System.out.print("\nEnter your name: ");
                    String userName = scan.nextLine();
                    System.out.print("Describe yourself: ");
                    String userDescription = scan.nextLine();
                    System.out.print("Due Date (MM/DD/YY): ");
                    String dueDate = scan.nextLine();

                    // Display user information
                    System.out.println("\nUsername: " + userName);
                    System.out.println("User Description: " + userDescription);
                    System.out.println("Date: " + dueDate);

                    // Write results to output file
                    try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
                        writer.write("Game Over\n");
                        if (gamePlayed) {
                            writer.write("You guessed " + correctGuesses + " out of " + MAX_GUESSES + " colors correctly.\n");
                        } else {
                            writer.write("You guessed 0 out of 0 colors correctly.\n"); // No game played
                        }
                        writer.write("Due Date: " + dueDate + "\n");
                        writer.write("Username: " + userName + "\n");
                        writer.write("User Description: " + userDescription + "\n");
                        writer.write("Date: " + dueDate + "\n");
                    } catch (IOException e) {
                        System.out.println("Error writing to file: " + e.getMessage());
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Exiting the program.");
                    System.exit(1);
            }

            // Display selected colors by reading the colors.txt file
            System.out.println("\nThere are " + colorCount + " colors from the file:");
            File file = new File(FILE_NAME);

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("Error: File '" + FILE_NAME + "' not found. Please ensure the file exists in the same directory as the program.");
                System.exit(1);
            }

            try (Scanner fileScanner = new Scanner(file)) {
                int count = 0;
                while (fileScanner.hasNextLine() && count < colorCount) {
                    String line = fileScanner.nextLine().trim();
                    if (!line.isEmpty()) { // Skip empty lines
                        System.out.println((count + 1) + " " + line);
                        count++;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                System.exit(1);
            }

            // Game logic
            correctGuesses = 0; // Reset correct guesses for the new game
            for (int round = 1; round <= MAX_GUESSES; round++) {
                System.out.println("\nRound " + round);
                System.out.println("I am thinking of a color.");
                System.out.println("Is it one of the list of colors above?");
                System.out.print("Enter your guess: ");
                String userGuess = scan.nextLine().trim();

                // Select a random color from the colors.txt file
                String selectedColor = "";
                try (Scanner fileScanner = new Scanner(file)) {
                    int randomIndex = rand.nextInt(colorCount);
                    int count = 0;
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine().trim();
                        if (!line.isEmpty()) { // Skip empty lines
                            if (count == randomIndex) {
                                selectedColor = line;
                                break;
                            }
                            count++;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                    System.exit(1);
                }

                System.out.println("I was thinking of " + selectedColor + ".");

                if (userGuess.equalsIgnoreCase(selectedColor)) {
                    correctGuesses++;
                }
            }

            System.out.println("\nGame Over");
            System.out.println("You guessed " + correctGuesses + " out of " + MAX_GUESSES + " colors correctly.");

            // Mark that a game has been played
            gamePlayed = true;

            // Ask if the user wants to play another game
            System.out.print("\nWould you like to play another game? (Yes/No): ");
            String playAgain = scan.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Exiting the program. Goodbye!");
                break; // Exit the loop and end the program
            }
        }
        
        // To terminate the background running thread.
        System.exit(0);
    }
}