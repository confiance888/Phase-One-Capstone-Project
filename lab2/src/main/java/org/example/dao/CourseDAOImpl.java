package org.example.dao;
import DB.DBConnection;
import org.example.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public void insertCourse(Course course) {
        String sql = "INSERT INTO courses (name, instructor) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getInstructorName());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    course.setCourseId(rs.getInt(1));
                }
            }

            System.out.println("Course inserted successfully!");

        } catch (SQLException e) {
            System.err.println("Error inserting course: " + e.getMessage());
        }
    }

    @Override
    public void deleteCourse(int courseId) {
        String sql = "DELETE FROM courses WHERE course_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            stmt.executeUpdate();
            System.out.println("Course deleted successfully!");

        } catch (SQLException e) {
            System.err.println("Error deleting course: " + e.getMessage());
        }
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Course course = new Course(
                        rs.getInt("course_id"),
                        rs.getString("name"),
                        rs.getString("instructor")
                );
                courses.add(course);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching courses: " + e.getMessage());
        }
        return courses;
    }
}
