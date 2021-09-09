package com.example.SpringBootDemo.controller;


import com.example.SpringBootDemo.model.Item;
import com.example.SpringBootDemo.model.Student;
import com.example.SpringBootDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.findAllStudents();

        if (students.isEmpty()){
            return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    }


    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") int id){
        Student student = studentService.findById(id);
        if(student == null){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @PostMapping("/createStudent")
    public ResponseEntity<?> createStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder){
        if(studentService.doesStudentExist(student)){
            return new ResponseEntity<Student>(HttpStatus.CONFLICT);
        }
        studentService.addStudent(student);
        return new ResponseEntity<Student>(HttpStatus.CREATED);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Student> updateUser(@RequestBody Student student){

        if(!studentService.doesStudentExist(student)){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        studentService.updateStudent(student);
        return new ResponseEntity<Student>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id){
        Student student = studentService.findById(id);

        if (student == null){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }

        studentService.deleteStudentById(id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

}
