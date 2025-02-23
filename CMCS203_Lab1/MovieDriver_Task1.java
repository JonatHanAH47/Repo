import java.util.Scanner;

public class MovieDriver {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner keyboard = new Scanner(System.in);

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

        // Print goodbye message
        System.out.println("Goodbye");

        // Close the Scanner object
        keyboard.close();
    }
}
