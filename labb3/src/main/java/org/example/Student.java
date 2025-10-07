package org.example;

public class Student {
    private int id;
    private String name;
    private String email;
    private String type;

    public Student() {}

    public Student(String name, String email, String type) {
        this.name = name;
        this.email = email;
        this.type = type;
    }

    public Student(int id, String name, String email, String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
    }

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "', type='" + type + "'}";
    }
}
