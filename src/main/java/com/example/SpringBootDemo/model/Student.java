package com.example.SpringBootDemo.model;

public class Student {

    private int id;
    private String name;
    private int grade;
    private String school;


    public Student() {
    }

    public Student(int id, String name, int grade, String school) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", school='" + school + '\'' +
                '}';
    }
}
