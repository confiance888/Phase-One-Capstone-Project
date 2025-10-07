import java.util.ArrayList;
import java.util.List;

public class UndergraduateStudent extends Student {
    private List<Double> grades;

    public UndergraduateStudent(int studentId, String name, String email) {
        super(studentId, name, email);
        grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    @Override
    public double calculateGPA() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }
}
