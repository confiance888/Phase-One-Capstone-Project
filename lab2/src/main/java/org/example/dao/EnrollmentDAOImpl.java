package org.example.dao;

import DB.DBConnection;
import org.example.Enrollment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAOImpl implements EnrollmentDAO {

    @Override
    public void enrollStudent(Enrollment enrollment) {
        String sql = "INSERT INTO enrollments (student_id, course_id, grade) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, enrollment.getStudentId());
            stmt.setInt(2, enrollment.getCourseId());
            stmt.setDouble(3, enrollment.getGrade());
            stmt.executeUpdate();

            System.out.println("Enrollment added successfully!");

        } catch (SQLException e) {
            System.err.println("Error adding enrollment: " + e.getMessage());
        }
    }

    @Override
    public void updateGrade(int studentId, int courseId, double newGrade) {
        String sql = "UPDATE enrollments SET grade=? WHERE student_id=? AND course_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newGrade);
            stmt.setInt(2, studentId);
            stmt.setInt(3, courseId);
            stmt.executeUpdate();

            System.out.println("Grade updated successfully!");

        } catch (SQLException e) {
            System.err.println("Error updating grade: " + e.getMessage());
        }
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM enrollments";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Enrollment enrollment = new Enrollment(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDouble("grade")
                );
                enrollments.add(enrollment);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching enrollments: " + e.getMessage());
        }
        return enrollments;
    }

    @Override
    public void deleteEnrollment(int studentId, int courseId) {
        String sql = "DELETE FROM enrollments WHERE student_id=? AND course_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.executeUpdate();

            System.out.println("Enrollment deleted successfully!");

        } catch (SQLException e) {
            System.err.println("Error deleting enrollment: " + e.getMessage());
        }
    }
}
