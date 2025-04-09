/*
 * Name: Pankaj Yadav
 * PRN: <23070126166>
 * Batch: AIML 2023–2027
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

         // Menu for operations
        do {
            System.out.println("\n1. Add Student\n2. View Students\n3. Update Student\n4. Delete Student\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: manager.addStudent(); break;
                case 2: manager.viewStudents(); break;
                case 3: manager.updateStudent(); break;
                case 4: manager.deleteStudent(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
