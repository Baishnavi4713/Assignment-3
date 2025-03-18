import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

public class UniversityEnrollment {
    private static final int MAX_CAPACITY = 2; // Change as needed
    private static int enrolledStudents = 2; // Example: Course is already full

    public static void enrollStudent(String course, boolean prerequisiteCompleted) throws CourseFullException, PrerequisiteNotMetException {
        if (enrolledStudents >= MAX_CAPACITY) {
            throw new CourseFullException("Error: CourseFullException - " + course + " is already full.");
        }
        if (!prerequisiteCompleted) {
            throw new PrerequisiteNotMetException("Error: PrerequisiteNotMetException - Complete Core Java before enrolling in " + course + ".");
        }
        
        enrolledStudents++;
        System.out.println("Enrollment successful in " + course + "!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();

            System.out.print("Prerequisite completed? (yes/no): ");
            String prerequisite = scanner.nextLine();

            boolean prerequisiteCompleted = prerequisite.equalsIgnoreCase("yes");

            enrollStudent(course, prerequisiteCompleted);

        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
