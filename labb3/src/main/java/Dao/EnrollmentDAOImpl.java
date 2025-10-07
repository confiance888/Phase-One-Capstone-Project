package Dao;



import DbConnectivity.DBConnection;
import org.example.Enrollment;
import org.example.models.EnrollmentDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAOImpl implements EnrollmentDAO {

    @Override
    public void enrollStudent(Enrollment enrollment) {
        String sql = "INSERT INTO enrollment(student_id, course_id, grade) VALUES (?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, enrollment.getStudentId());
            stmt.setInt(2, enrollment.getCourseId());
            stmt.setDouble(3, enrollment.getGrade());
            stmt.executeUpdate();
            System.out.println("✅ Enrollment added successfully");

        } catch (SQLException e) {
            System.err.println("❌ Error adding enrollment: " + e.getMessage());
        }
    }

    @Override
    public void updateGrade(int studentId, int courseId, double grade) {
        String sql = "UPDATE enrollments SET grade=? WHERE student_id=? AND course_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, grade);
            stmt.setInt(2, studentId);
            stmt.setInt(3, courseId);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Grade updated successfully");
            else
                System.out.println("⚠️ No matching enrollment found");

        } catch (SQLException e) {
            System.err.println("❌ Error updating grade: " + e.getMessage());
        }
    }

    @Override
    public List<EnrollmentDetails> getAllEnrollmentDetails() {
        List<EnrollmentDetails> list = new ArrayList<>();
        String sql = "SELECT e.id,e.grade, s.name AS student_name, c.name AS course_name " +
                "FROM enrollment e " +
                "JOIN students s ON e.student_id = s.student_id " +
                "JOIN courses c ON e.course_id = c.course_id";


        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new EnrollmentDetails(
                        rs.getString("student_name"),
                        rs.getString("course_name"),
                        rs.getDouble("grade")
                ));
            }

        } catch (SQLException e) {
            System.err.println("❌ Error fetching enrollments: " + e.getMessage());
        }

        return list;
    }
}
