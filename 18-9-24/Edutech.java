import java.util.HashMap;
import java.util.Scanner;

public class Edutech {
    // HashMap to store user details with username as the key
    private static HashMap<String, String[]> userDatabase = new HashMap<>();

    // Courses available
    private static String[] courses = { 
        "1001 - Java (10000 - with certification)"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to ABC Edutech Company");

        // Registration Process
        System.out.println("Please register with your details");
        System.out.print("Please enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Please enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();

        // Storing user details in the database
        userDatabase.put(username, new String[]{firstName, lastName, password});
        System.out.println("Thank you... your details are with us.");

        // Login Process
        boolean loginSuccessful = false;
        while (!loginSuccessful) {
            System.out.println("Please login with your details");
            System.out.print("Please enter username: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Please enter password: ");
            String loginPassword = scanner.nextLine();

            if (validateLogin(loginUsername, loginPassword)) {
                System.out.println("Login successful! Welcome back, " + userDatabase.get(loginUsername)[0] + "!");
                loginSuccessful = true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        // Display available courses
        System.out.println("List of courses offered by ABC Edutech Company:");
        for (String course : courses) {
            System.out.println(course);
        }

        scanner.close();
    }

    // Method to validate login details
    private static boolean validateLogin(String username, String password) {
        if (userDatabase.containsKey(username)) {
            return userDatabase.get(username)[2].equals(password);
        }
        return false;
    }
}
