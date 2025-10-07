package Dao;


import DbConnectivity.DBConnection;
import org.example.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public void insertCourse(Course course) {
        String sql = "INSERT INTO courses(name,instructor) VALUES (?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getName());
            stmt.setString(2, course.getInstructor());
            stmt.executeUpdate();
            System.out.println("✅ Course added successfully");

        } catch (SQLException e) {
            System.err.println("❌ Error adding course: " + e.getMessage());
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
                courses.add(new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("instructor")
                ));
            }

        } catch (SQLException e) {
            System.err.println("❌ Error fetching courses: " + e.getMessage());
        }
        return courses;
    }
}
