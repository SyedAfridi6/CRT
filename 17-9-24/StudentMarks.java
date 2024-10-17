import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        int[] marks = new int[7];
        Scanner scanner = new Scanner(System.in);

        // Read marks for each subject
        for (int i = 0; i < 7; i++) {
            String subject;
            switch (i) {
                case 0:
                    subject = "Corejava";
                    break;
                case 1:
                    subject = "Html";
                    break;
                case 2:
                    subject = "CSS";
                    break;
                case 3:
                    subject = "Bootstrap";
                    break;
                case 4:
                    subject = "ES6";
                    break;
                case 5:
                    subject = "Spring";
                    break;
                case 6:
                    subject = "Hibernate";
                    break;
                default:
                    subject = "Unknown";
            }
            System.out.printf("Please enter marks in %s%n", subject);
            marks[i] = scanner.nextInt();
        }

        // Find the highest marks
        int highestMarks = marks[0];
        int highestSubject = 0;
        for (int i = 1; i < 7; i++) {
            if (marks[i] > highestMarks) {
                highestMarks = marks[i];
                highestSubject = i;
            }
        }

        // Determine the subject with the highest marks
        String highestSubjectName = "";
        switch (highestSubject) {
            case 0: highestSubjectName = "Corejava"; break;
            case 1: highestSubjectName = "Html"; break;
            case 2: highestSubjectName = "CSS"; break;
            case 3: highestSubjectName = "Bootstrap"; break;
            case 4: highestSubjectName = "ES6"; break;
            case 5: highestSubjectName = "Spring"; break;
            case 6: highestSubjectName = "Hibernate"; break;
        }

        // Store the result in a file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));
            writer.write("Highest marks in " + highestSubjectName + " are: " + highestMarks);
            writer.newLine();
            writer.write("Your results are stored in a file. Please check the results.txt file.");
            writer.close();
            System.out.println("Highest marks in " + highestSubjectName + " are: " + highestMarks);
            System.out.println("Your results are stored in a file. Please check the results.txt file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
