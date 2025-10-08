package org.example;

public class Enrollment {
    private int studentId;
    private int courseId;
    private double grade;

    public Enrollment(int studentId, int courseId, double grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public int getStudentId() {

        return studentId;
    }

    public int getCourseId() {

        return courseId;
    }

    public double getGrade() {

        return grade;
    }

    @Override
    public String toString() {
        return "Enrollment{" +"studentId=" + studentId + ", courseId=" + courseId + ", grade=" + grade + '}';

    }
}
