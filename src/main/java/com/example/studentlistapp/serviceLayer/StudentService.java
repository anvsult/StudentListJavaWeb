package com.example.studentlistapp.serviceLayer;

import com.example.studentlistapp.dataAccessLayer.Student;
import com.example.studentlistapp.dataAccessLayer.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //GETTING ALL STUDENTS
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    //ADDING A STUDENT
    public Student addStudent(Student student) {
        Student savedStudent = null;
        String email = student.getEmail();
        Optional<Student> foundStudent = studentRepository.findStudentByEmail(email);
        if (foundStudent.isEmpty()) {
            int ageInYears = LocalDate.now().getYear() - student.getDob().getYear();
            student.setAge(ageInYears);
            savedStudent = studentRepository.save(student);
        }
        return savedStudent;
    }

    //DELETING A STUDENT BY ID
    public String deleteStudentById(String id) {
        Long idKey = Long.parseLong(id);
        studentRepository.deleteById(idKey);
        return "Student with id " + id + " deleted successfully.";
    }

    //UPDATING A STUDENT
    public Student updateStudent(String id, Student newStudentData) {
        Student savedStudent = null;
        Long idKey = Long.parseLong(id);
        Optional<Student> foundStudent = studentRepository.findById(idKey);
        if (foundStudent.isPresent()) {
            System.out.println("Given id: " + idKey + " found student " + foundStudent.get().getName());
            int ageInYears = LocalDate.now().getYear() - newStudentData.getDob().getYear();
            newStudentData.setAge(ageInYears);
            newStudentData.setId(idKey); //important to set the same key,
            //otherwise a new student will be inserted instead of overwriting the old one with that id
            savedStudent = studentRepository.save(newStudentData);
            System.out.println("Saved students: " + savedStudent.getName() + " " + savedStudent.getEmail());
        }
        return savedStudent;

    }

    //GET STUDENT BY ID
    public Optional<Student> getStudentById(String id) {
        Long idKey = Long.parseLong(id);
        return studentRepository.findById(idKey);
    }

    //GETTING STUDENT BY EMAIL
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }
}
