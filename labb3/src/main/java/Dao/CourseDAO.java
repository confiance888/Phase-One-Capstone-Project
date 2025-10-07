package Dao;


import org.example.Course;

import java.util.List;

public interface CourseDAO {
    void insertCourse(Course course);
    List<Course> getAllCourses();
}
