import java.util.*;

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create instructors
        Instructor profSmith = new Instructor(1, "Confiance Umutoni", "Software Engneering");
        Instructor profJones = new Instructor(2, "ange Umutoni", "Information Managment");

        // Create courses
        Course javaCourse = new Course(101, "Java Programming", profSmith);
        Course calculus = new Course(102, "MobileProgramming", profJones);

        // List to store all students
        List<Student> students = new ArrayList<>();

        // Menu loop
        boolean running = true;
        while (running) {
            System.out.println("\n--- University Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Course Rosters");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add student
                    System.out.print("Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Student Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Student Type (1=Undergraduate, 2=Graduate): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    Student student;
                    if (type == 1) {
                        student = new UndergraduateStudent(id, name, email);
                    } else {
                        student = new GraduateStudent(id, name, email);
                    }

                    System.out.print("Enter number of grades: ");
                    int g = scanner.nextInt();
                    scanner.nextLine();
                    for (int j = 0; j < g; j++) {
                        System.out.print("Grade #" + (j + 1) + ": ");
                        double grade = scanner.nextDouble();
                        scanner.nextLine();
                        if (student instanceof UndergraduateStudent) {
                            ((UndergraduateStudent) student).addGrade(grade);
                        } else {
                            ((GraduateStudent) student).addGrade(grade);
                        }
                    }

                    // Enroll in courses
                    System.out.print("Enroll in Java Programming? (y/n): ");
                    String enrollJava = scanner.nextLine();
                    if (enrollJava.equalsIgnoreCase("y")) javaCourse.enrollStudent(student);

                    System.out.print("Enroll in MobileProgramming? (y/n): ");
                    String enrollCalc = scanner.nextLine();
                    if (enrollCalc.equalsIgnoreCase("y")) calculus.enrollStudent(student);

                    students.add(student);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    // View course rosters
                    List<Course> courses = Arrays.asList(javaCourse, calculus);
                    System.out.println("\n--- Course Rosters ---");
                    for (Course c : courses) {
                        System.out.println(c);
                        for (Student s : c.getEnrolledStudents()) {
                            System.out.println(" - " + s + ", GPA=" + s.calculateGPA());
                        }
                    }
                    break;

                case 3:
                    // Exit program
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }
}
