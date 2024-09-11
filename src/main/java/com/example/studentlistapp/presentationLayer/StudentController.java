package com.example.studentlistapp.presentationLayer;

import com.example.studentlistapp.serviceLayer.StudentService;
import com.example.studentlistapp.dataAccessLayer.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }
    @PostMapping()
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable String id) {
        return studentService.deleteStudentById(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student newStudentData) {
        return studentService.updateStudent(id, newStudentData);
    }
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }
    @GetMapping("/email/{email}")
    public Optional<Student> getStudentByEmail(@PathVariable String email){
        System.out.println(email);
        return studentService.getStudentByEmail(email);
    }

}
