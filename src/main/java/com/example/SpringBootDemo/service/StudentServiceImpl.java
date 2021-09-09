package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("studentService")
public class StudentServiceImpl implements StudentService{

    private static List<Student> students;

    static {
        students = populateList();
    }

    @Override
    public Student findById(int id) {
        for(Student student: students){
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public Student findByName(String name) {
        for(Student student: students){
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        for (Student student1 : students){
            if(student.getId() == student1.getId()){
                int index = students.indexOf(student1);
                students.set(index, student);
                break;
            }
        }
    }

    @Override
    public void deleteStudentById(int id) {
        for (Student student: students){
            if(student.getId() == id){
                students.remove(student);
                break;
            }
        }
    }

    @Override
    public List<Student> findAllStudents() {
        return students;
    }

    @Override
    public void deleteAllStudents() {
        students.clear();
    }

    @Override
    public boolean doesStudentExist(Student student) {

        return findById(student.getId()) != null;
    }

    private static List<Student> populateList(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Alice", 8, "Oakwoods high"));
        students.add(new Student(102, "Bob", 9, "Central Public"));
        students.add(new Student(103, "Chris", 10, "Yellow School"));
        students.add(new Student(104, "Dave", 6, "Oakwoods Middle"));
        students.add(new Student(105, "Eve", 9, "Oakwoods high"));
        return students;
    }
}
