package org.example.dao;

import org.example.Enrollment;
import java.util.List;

public interface EnrollmentDAO {
    void enrollStudent(Enrollment enrollment);
    void updateGrade(int studentId, int courseId, double newGrade);
    List<Enrollment> getAllEnrollments();
    void deleteEnrollment(int studentId, int courseId); // <-- for delete option
}
