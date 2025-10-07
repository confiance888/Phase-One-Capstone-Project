package org.example.dao;
import DB.DBConnection;
import org.example.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void insertStudent(Student student) {
        String sql = "INSERT INTO students (name, email, type) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getType());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    student.setStudentId(rs.getInt(1));
                }
            }

            System.out.println("Student inserted successfully!");

        } catch (SQLException e) {
            System.err.println("Error inserting student: " + e.getMessage());
        }
    }

    @Override
    public void updateStudentEmail(int studentId, String newEmail) {
        String sql = "UPDATE students SET email=? WHERE student_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newEmail);
            stmt.setInt(2, studentId);
            stmt.executeUpdate();

            System.out.println("Student email updated successfully!");

        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.executeUpdate();

            System.out.println("Student deleted successfully!");

        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("type")
                );
                students.add(student);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching students: " + e.getMessage());
        }
        return students;
    }
}
