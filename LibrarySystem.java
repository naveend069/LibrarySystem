import java.util.*;
import java.time.LocalDate;

class BookManager {
    public void showBooksByDepartment(Scanner sc) {
        System.out.print("Enter your department: ");
        String department = sc.nextLine().toUpperCase();

        switch (department) {
            case "CSE":
                System.out.println("Recommended Books for CSE:");
                System.out.println("1. Introduction to Algorithms - Thomas H. Cormen");
                System.out.println("2. Clean Code - Robert C. Martin");
                System.out.println("3. Java: The Complete Reference - Herbert Schildt");
                break;
            case "ECE":
                System.out.println("Recommended Books for ECE:");
                System.out.println("1. Digital Design - M. Morris Mano");
                System.out.println("2. Signals and Systems - Alan V. Oppenheim");
                break;
            case "MECHANICAL":
                System.out.println("Recommended Books for Mechanical:");
                System.out.println("1. Thermodynamics - Yunus A. Cengel");
                System.out.println("2. Fluid Mechanics - Frank M. White");
                break;
            default:
                System.out.println("Sorry, no book list available for this department.");
        }
    }
}

class StudentManager {
    private final Map<String, String> studentBooks = new HashMap<>();
    private final Map<String, String> studentDueDates = new HashMap<>();

    public StudentManager() {
        studentBooks.put("NAVEEN", "Data Structures and Algorithms - Alfred V. Aho");
        studentBooks.put("SOWNDHAR", "The Art of Computer Programming - Donald E. Knuth");
        studentBooks.put("YOGESH", "Java: The Complete Reference - Herbert Schildt");
        studentBooks.put("RAJ", "Operating System Concepts - Abraham Silberschatz");
        studentBooks.put("SATHISH", "AI: A Modern Approach - Russell & Norvig");

        studentDueDates.put("NAVEEN", "2025-06-15");
        studentDueDates.put("SOWNDHAR", "2025-06-20");
        studentDueDates.put("YOGESH", "2025-06-25");
        studentDueDates.put("RAJ", "2025-06-30");
        studentDueDates.put("SATHISH", "2025-07-05");
    }

    public void showStudentDetails(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine().toUpperCase();

        if (studentBooks.containsKey(name)) {
            System.out.println("Student: " + name);
            System.out.println("Borrowed Book: " + studentBooks.get(name));
            System.out.println("Due Date: " + studentDueDates.get(name));
        } else {
            System.out.println("Student not found.");
        }
    }

    public void checkDueDate(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine().toUpperCase();

        if (studentDueDates.containsKey(name)) {
            LocalDate dueDate = LocalDate.parse(studentDueDates.get(name));
            LocalDate today = LocalDate.now();

            if (today.isAfter(dueDate)) {
                System.out.println("You have not returned the book on time.");
            } else {
                System.out.println("You have returned the book on time.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager bookManager = new BookManager();
        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. View Recommended Books");
            System.out.println("2. View Student Borrow Details");
            System.out.println("3. Check Due Date");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    bookManager.showBooksByDepartment(sc);
                    break;
                case "2":
                    studentManager.showStudentDetails(sc);
                    break;
                case "3":
                    studentManager.checkDueDate(sc);
                    break;
                case "4":
                    System.out.println("Thank you. Have a good day!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
