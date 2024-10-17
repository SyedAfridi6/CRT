import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Thread class for printing movie lists for each actor
class MovieThread extends Thread {
    private String actor;
    private List<String> movies;

    public MovieThread(String actor, List<String> movies) {
        this.actor = actor;
        this.movies = movies;
    }

    @Override
    public void run() {
        System.out.println(actor + " Movies:");
        for (String movie : movies) {
            System.out.println(movie);
        }
    }
}

public class BollywoodMoviesMultithreaded {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Map to store movies for different actors
        Map<String, List<String>> actorMovies = new HashMap<>();

        // Adding Sharukh movies to the map
        List<String> sharukhMovies = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            sharukhMovies.add("Sharukh Movie " + i);
        }
        actorMovies.put("Sharukh", sharukhMovies);

        // Adding Salman movies to the map
        List<String> salmanMovies = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            salmanMovies.add("Salman Movie " + i);
        }
        actorMovies.put("Salman", salmanMovies);

        // Adding Aamir movies to the map
        List<String> aamirMovies = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            aamirMovies.add("Aamir Movie " + i);
        }
        actorMovies.put("Aamir", aamirMovies);

        // Prompting user for input
        System.out.println("Please enter your input to search (BollywoodMovies, Sharukh, Salman, Aamir or any actor name): ");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("BollywoodMovies")) {
            // Case 1: List all Bollywood movies using multiple threads
            System.out.println("Bollywood Movies:");
            List<Thread> threads = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : actorMovies.entrySet()) {
                MovieThread thread = new MovieThread(entry.getKey(), entry.getValue());
                threads.add(thread);
                thread.start(); // Start the thread for each actor
            }
            // Wait for all threads to finish
            for (Thread t : threads) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (actorMovies.containsKey(input)) {
            // Case 2: List movies for the specified actor using a thread
            MovieThread thread = new MovieThread(input, actorMovies.get(input));
            thread.start();
            try {
                thread.join(); // Ensure the thread finishes before exiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid input or no movies found for the specified actor!");
        }

        scanner.close();
    }
}
