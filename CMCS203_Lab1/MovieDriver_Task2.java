import java.util.Scanner;

public class MovieDriver {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Variable to control the loop
        String continueInput;

        do {
            // Create a new Movie object
            Movie movie = new Movie();

            // Prompt the user to enter the title of a movie
            System.out.println("Enter the name of a movie:");
            String title = keyboard.nextLine();
            movie.setTitle(title); // Set the title in the movie object

            // Prompt the user to enter the movie's rating
            System.out.println("Enter the rating of the movie:");
            String rating = keyboard.nextLine();
            movie.setRating(rating); // Set the rating in the movie object

            // Prompt the user to enter the number of tickets sold
            System.out.println("Enter the number of tickets sold for this movie:");
            int ticketsSold = keyboard.nextInt();
            movie.setSoldTickets(ticketsSold); // Set the number of tickets sold in the movie object

            // Print out the information using the movie's toString method
            System.out.println(movie.toString());

            // Consume the leftover newline character
            keyboard.nextLine();

            // Ask the user if they want to continue
            System.out.println("Do you want to enter another? (y or n):");
            continueInput = keyboard.nextLine();

        } while (continueInput.equalsIgnoreCase("y")); // Continue the loop if the user enters 'y'

        // Print goodbye message
        System.out.println("Goodbye");

        // Close the Scanner object
        keyboard.close();
    }
}