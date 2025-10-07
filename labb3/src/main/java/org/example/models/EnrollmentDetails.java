package org.example.models;  // make sure this matches your package structure

public class EnrollmentDetails {
    private String studentName;
    private String courseName;
    private double grade;

    public EnrollmentDetails(String studentName, String courseName, double grade) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.grade = grade;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "EnrollmentDetails{" +
                "studentName='" + studentName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", grade=" + grade +
                '}';
    }
}
