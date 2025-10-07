package org.example;

import Dao.*;
import org.example.models.EnrollmentDetails;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();
        CourseDAO courseDAO = new CourseDAOImpl();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAOImpl();

        while (true) {
            System.out.println("\n=== UNIVERSITY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Update Student Grade");
            System.out.println("5. View All Enrollments");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Student Name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Email: ");
                    String email = scanner.nextLine().trim();

                    System.out.print("Type (Undergraduate/Graduate): ");
                    String type = scanner.nextLine().trim();

                    studentDAO.insertStudent(new Student(name, email, type));
                }

                case 2 -> {
                    System.out.print("Course Name: ");
                    String cname = scanner.nextLine().trim();

                    System.out.print("Instructor: ");
                    String instructor = scanner.nextLine().trim();

                    courseDAO.insertCourse(new Course(cname, instructor));
                }

                case 3 -> {
                    System.out.print("Student ID: ");
                    int sid = readInt();

                    System.out.print("Course ID: ");
                    int cid = readInt();

                    System.out.print("Grade: ");
                    double grade = readDouble();

                    enrollmentDAO.enrollStudent(new Enrollment(sid, cid, grade));
                }

                case 4 -> {
                    System.out.print("Student ID: ");
                    int sid = readInt();

                    System.out.print("Course ID: ");
                    int cid = readInt();

                    System.out.print("New Grade: ");
                    double grade = readDouble();

                    enrollmentDAO.updateGrade(sid, cid, grade);
                }

                case 5 -> {
                    List<EnrollmentDetails> enrollments = enrollmentDAO.getAllEnrollmentDetails();
                    enrollments.forEach(System.out::println);
                }

                case 6 -> {
                    System.out.print("Student ID to delete: ");
                    int sid = readInt();
                    studentDAO.deleteStudent(sid);
                }

                case 7 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }

                default -> System.out.println("⚠️ Invalid choice! Try again.");
            }
        }
    }

    // ----------------- Helper Methods -----------------
    private static int readInt() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("⚠️ Please enter a valid integer: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("⚠ Please enter a valid number: ");
            }
        }
    }
}
