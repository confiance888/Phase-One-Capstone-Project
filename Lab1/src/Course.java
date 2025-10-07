import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private Instructor instructor;
    private List<Student> enrolledStudents;

    public Course(int courseId, String courseName, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public String toString() {
        return "Course [ID=" + courseId + ", Name=" + courseName + ", Instructor=" + instructor.getName() + "]";
    }
}
