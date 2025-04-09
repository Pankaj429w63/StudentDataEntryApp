import exceptions.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Function to add student
    public void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter Name: ");
            String name = scanner.next();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            if (age < 5 || name.length() < 2) {
                throw new InvalidStudentDataException("Invalid student data provided.");
            }

            students.add(new Student(id, name, age));
            System.out.println("Student added successfully.");
        } catch (InvalidStudentDataException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        }
    }

    // Function to view all students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
        } else {
            for (Student s : students) {
                System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge());
            }
        }
    }

    // Function to update a student
    public void updateStudent() {
        try {
            System.out.print("Enter student ID to update: ");
            int id = scanner.nextInt();
            Student student = findStudentById(id);

            System.out.print("Enter new Name: ");
            String name = scanner.next();
            System.out.print("Enter new Age: ");
            int age = scanner.nextInt();

            if (age < 5 || name.length() < 2) {
                throw new InvalidStudentDataException("Invalid student data for update.");
            }

            student.setName(name);
            student.setAge(age);
            System.out.println("Student updated successfully.");

        } catch (StudentNotFoundException | InvalidStudentDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Function to delete a student
    public void deleteStudent() {
        try {
            System.out.print("Enter student ID to delete: ");
            int id = scanner.nextInt();
            Student student = findStudentById(id);
            students.remove(student);
            System.out.println("Student deleted successfully.");
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Helper method
    private Student findStudentById(int id) throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found.");
    }
}
