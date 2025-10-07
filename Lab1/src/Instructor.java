public class Instructor {
    private int instructorId;
    private String name;
    private String department;

    public Instructor(int instructorId, String name, String department) {
        this.instructorId = instructorId;
        this.name = name;
        this.department = department;
    }

    public int getInstructorId() { return instructorId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "Instructor [ID=" + instructorId + ", Name=" + name + ", Dept=" + department + "]";
    }
}
