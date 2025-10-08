package org.example.dao;

import org.example.Course;

import java.util.List;

public interface CourseDAO {
    void insertCourse(Course course);       // Create
    void deleteCourse(int courseId);        // Delete
    List<Course> getAllCourses();           // Read
}
