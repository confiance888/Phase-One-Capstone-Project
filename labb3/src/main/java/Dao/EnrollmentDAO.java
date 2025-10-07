package Dao;

import org.example.Enrollment;
import org.example.models.EnrollmentDetails;

import java.util.List;

public interface EnrollmentDAO {
    void enrollStudent(Enrollment enrollment);
    void updateGrade(int studentId, int courseId, double grade);
    List<EnrollmentDetails> getAllEnrollmentDetails();
}
