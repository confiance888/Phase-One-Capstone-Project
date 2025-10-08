package org.example;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private String type; // "Undergraduate" or "Graduate"

    public Student() { }

    public Student(int studentId, String name, String email, String type) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.type = type;
    }

    public Student(String name, String email, String type) {
        this.name = name;
        this.email = email;
        this.type = type;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {

        this.type = type;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + studentId +", name='" + name + '\'' +", email='" + email + '\'' +", type='" + type + '\'' + '}';




    }
}
