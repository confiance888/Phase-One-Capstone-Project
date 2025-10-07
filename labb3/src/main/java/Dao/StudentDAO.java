package Dao;

import org.example.Student;

import java.util.List;

public interface StudentDAO {
    void insertStudent(Student student);
    List<Student> getAllStudents();
    void deleteStudent(int id);
}
