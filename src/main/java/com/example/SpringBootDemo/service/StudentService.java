package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.model.Student;

import java.util.List;

public interface StudentService {

    Student findById(int id);

    Student findByName(String name);

    void addStudent(Student Student);

    void updateStudent(Student Student);

    void deleteStudentById(int id);

    List<Student> findAllStudents();

    void deleteAllStudents();

    boolean doesStudentExist(Student Student);
}
