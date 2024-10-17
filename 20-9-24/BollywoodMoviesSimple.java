import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BollywoodMoviesSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> sharukhMovies = new ArrayList<>();
        List<String> salmanMovies = new ArrayList<>();

        // Adding Sharukh and Salman movies to the lists
        for (int i = 1; i <= 10; i++) {
            sharukhMovies.add("Sharukh Movie " + i);
            salmanMovies.add("Salman Movie " + i);
        }

        System.out.println("Please enter your input to search (BollywoodMovies, SharukhMovies, SalmanMovies): ");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("BollywoodMovies")) {
            // Case 1: List all Bollywood movies
            System.out.println("Bollywood Movies:");
            for (int i = 0; i < 10; i++) {
                System.out.println(sharukhMovies.get(i));
                System.out.println(salmanMovies.get(i));
            }
        } else if (input.equalsIgnoreCase("SharukhMovies")) {
            // Case 2: List only Sharukh movies
            System.out.println("Sharukh Movies:");
            for (String movie : sharukhMovies) {
                System.out.println(movie);
            }
        } else if (input.equalsIgnoreCase("SalmanMovies")) {
            // Case 3: List only Salman movies
            System.out.println("Salman Movies:");
            for (String movie : salmanMovies) {
                System.out.println(movie);
            }
        } else {
            System.out.println("Invalid input! Please enter a valid option.");
        }

        scanner.close();
    }
}
