package org.example;


public class Course {
    private int id;
    private String name;
    private String instructor;

    public Course() {}

    public Course(String name, String instructor) {
        this.name = name;
        this.instructor = instructor;
    }

    public Course(int id, String name, String instructor) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
    }

    // getters & setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getInstructor() { return instructor; }

    @Override
    public String toString() {
        return "Course{id=" + id + ", name='" + name + "', instructor='" + instructor + "'}";
    }
}
