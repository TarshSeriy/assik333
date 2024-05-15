package org.example.utils.classes;

public class Student {
    private int id;
    private double gpa;
    private char gender;
    private String name;

    public Student(int id, double gpa, char gender, String name) {
        this.id = id;
        this.gpa = gpa;
        this.gender = gender;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public char getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", gpa=" + gpa +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                '}';
    }
}
