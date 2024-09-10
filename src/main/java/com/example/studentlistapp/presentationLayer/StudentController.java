package com.example.studentlistapp.presentationLayer;

import com.example.studentlistapp.serviceLayer.StudentService;
import com.example.studentlistapp.dataAccessLayer.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = new StudentService();
    }

    @GetMapping("/api/v1/students")
    public List<Student> index() {
        return studentService.getStudents();
    }

}
