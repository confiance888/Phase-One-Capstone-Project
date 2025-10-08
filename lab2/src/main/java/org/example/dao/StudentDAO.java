package org.example.dao;
import org.example.Student;

import java.util.List;

public interface StudentDAO {

    void insertStudent(Student student);          // Create
    void updateStudentEmail(int studentId, String newEmail); // Update
    void deleteStudent(int studentId);            // Delete
    List<Student> getAllStudents();               // Read
}
