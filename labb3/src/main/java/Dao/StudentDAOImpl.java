package Dao;


import DbConnectivity.DBConnection;
import org.example.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void insertStudent(Student student) {
        String sql = "INSERT INTO students(name,email,type) VALUES (?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getType());
            stmt.executeUpdate();
            System.out.println("✅ Student added successfully");

        } catch (SQLException e) {
            System.err.println("❌ Error adding student: " + e.getMessage());
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
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("type")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error fetching students: " + e.getMessage());
        }
        return students;
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Student deleted successfully");

        } catch (SQLException e) {
            System.err.println("❌ Error deleting student: " + e.getMessage());
        }
    }
}
