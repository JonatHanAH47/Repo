import java.util.*;
import java.io.*;

public class ESPGame {
    private static final String FILE_NAME = "colors.txt"; // Default file name
    private static final String OUTPUT_FILE = "EspGameResults.txt";
    private static final String MENU = "A. Read and display the first 16 colors from the colors.txt file\n" +
                                       "B. Read and display the first 10 colors from the colors.txt file\n" +
                                       "C. Read and display the first 5 colors from the colors.txt file\n" +
                                       "D. Exit\n";
    private static final int MAX_COLORS = 16;
    private static final int MAX_GUESSES = 3;

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

                    // Write results to file
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

            // Read colors from file
            String[] colors = new String[MAX_COLORS];
            File file = new File(FILE_NAME); // Use the default file name

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("Error: File '" + FILE_NAME + "' not found. Please ensure the file exists in the same directory as the program.");
                System.exit(1);
            }

            try (Scanner fileScanner = new Scanner(file)) {
                int index = 0;
                while (fileScanner.hasNextLine() && index < MAX_COLORS) {
                    String line = fileScanner.nextLine().trim();
                    if (!line.isEmpty()) { // Skip empty lines
                        colors[index] = line;
                        index++;
                    }
                }
                System.out.println("Successfully read " + index + " colors from the file."); // Debugging
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                System.exit(1);
            }

            // Display selected colors
            System.out.println("\nThere are " + colorCount + " colors from the file:");
            for (int i = 0; i < colorCount; i++) {
                System.out.println((i + 1) + " " + (colors[i] != null ? colors[i] : "null"));
            }

            // Game logic
            correctGuesses = 0; // Reset correct guesses for the new game
            for (int round = 1; round <= MAX_GUESSES; round++) {
                System.out.println("\nRound " + round);
                System.out.println("I am thinking of a color.");
                System.out.println("Is it one of the list of colors above?");
                System.out.print("Enter your guess: ");
                String userGuess = scan.nextLine().trim();

                int randomIndex = rand.nextInt(colorCount);
                String selectedColor = colors[randomIndex];

                if (userGuess.equalsIgnoreCase(selectedColor)) {
                    correctGuesses++;
                }
                System.out.println("I was thinking of " + selectedColor + ".");
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