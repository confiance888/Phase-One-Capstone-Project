package org.example;

public class Course {
    private int courseId;
    private String courseName;
    private String instructorName;

    public Course() { }

    public Course(int courseId, String courseName, String instructorName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorName = instructorName;
    }

    public Course(String courseName, String instructorName) {
        this.courseName = courseName;
        this.instructorName = instructorName;
    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getInstructorName() {
        return instructorName;
    }
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    @Override
    public String toString() {
        return "Course{" +"id=" + courseId +", name='" + courseName + '\'' +", instructor='" + instructorName + '\'' +  '}';




    }
}
