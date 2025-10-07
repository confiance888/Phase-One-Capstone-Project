package org.example;

import org.example.dao.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Initialize DAO implementations
        StudentDAO studentDAO = new StudentDAOImpl();
        CourseDAO courseDAO = new CourseDAOImpl();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAOImpl();

        // --- 1. Insert Student ---
        Student student1 = new Student("confy", "confy@gmail.com", "Undergraduate");
        Student student2 = new Student("umutoni", "umutoni@gmail.com", "Graduate");
        studentDAO.insertStudent(student1);
        studentDAO.insertStudent(student2);

        // --- 2. Insert Courses ---
        Course course1 = new Course("bigdata", "Dr. confie");
        Course course2 = new Course("software", "Dr. umutoni");
        courseDAO.insertCourse(course1);
        courseDAO.insertCourse(course2);

        // --- 3. List all courses ---
        System.out.println("\n--- All Courses ---");
        List<Course> courses = courseDAO.getAllCourses();
        courses.forEach(System.out::println);

        // --- 4. Update Enrollment Grade ---
        // Suppose student with ID 1 is enrolled in course with ID 1
        enrollmentDAO.updateGrade(1, 1, 95.0);
        System.out.println("\nUpdated grade for student 1 in course 1");

        // --- 5. Delete a student ---
        studentDAO.deleteStudent(2);
        System.out.println("\n Deleted student with ID 2");

        // --- 6. List all students ---
        System.out.println("\n--- All Students ---");
        List<Student> students = studentDAO.getAllStudents();
        students.forEach(System.out::println);

        System.out.println("\nProgram finished successfully!");
    }
}
