package com.example.studentlistapp.serviceLayer;

import com.example.studentlistapp.dataAccessLayer.Student;
import com.example.studentlistapp.dataAccessLayer.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

}
