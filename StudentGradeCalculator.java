import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display a header for the calculator
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║          STUDENT GRADE CALCULATOR     ║");
        System.out.println("╚═══════════════════════════════════════╝");

        // Input: Number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Initialize variables
        double[] marks = new double[numSubjects];
        double totalMarks = 0;

        System.out.println("\nEnter marks for each subject (out of 100):");

        // Input: Marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.printf("  Subject %d: ", i + 1);
            marks[i] = scanner.nextDouble();

            // Validate marks
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("  ⚠ Invalid marks! Enter a value between 0 and 100.");
                i--; // Retry input for the same subject
                continue;
            }

            totalMarks += marks[i];
        }

        // Calculate total, average percentage, and grade
        double averagePercentage = totalMarks / numSubjects;
        char grade = calculateGrade(averagePercentage);

        // Display results in a formatted manner
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║                RESULTS                ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.printf("║ %-20s : %10.2f ║\n", "Total Marks", totalMarks);
        System.out.printf("║ %-20s : %10.2f%% ║\n", "Average Percentage", averagePercentage);
        System.out.printf("║ %-20s : %10c ║\n", "Grade", grade);
        System.out.println("╚═══════════════════════════════════════╝");

        // Close the scanner
        scanner.close();
    }

    // Method to calculate grade based on average percentage
    public static char calculateGrade(double percentage) {
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
