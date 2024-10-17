import java.util.HashMap;

public class StudentImpl implements IStudent {
    // HashMap to store username and associated details: {firstname, lastname, password}
    private HashMap<String, String[]> studentDatabase = new HashMap<>();

    // Register student details
    @Override
    public boolean register(String firstName, String lastName, String username, String password) {
        // Check if the username is already registered
        if (!studentDatabase.containsKey(username)) {
            studentDatabase.put(username, new String[]{firstName, lastName, password});
            return true; // Registration successful
        }
        return false; // Registration failed - Username already exists
    }

    // Login validation
    @Override
    public boolean login(String username, String password) {
        // Check if the username exists in the database
        if (studentDatabase.containsKey(username)) {
            // Validate the password
            return studentDatabase.get(username)[2].equals(password);
        }
        return false; // Login failed - Username not found or incorrect password
    }
}
