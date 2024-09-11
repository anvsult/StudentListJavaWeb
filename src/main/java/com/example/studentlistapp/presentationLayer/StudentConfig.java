package com.example.studentlistapp.presentationLayer;

import com.example.studentlistapp.dataAccessLayer.Student;
import com.example.studentlistapp.dataAccessLayer.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    LocalDate.now().getYear() - 2000
            );
            Student alex = new Student(
                    "Alex", "alex@gmail.com",
                    LocalDate.of(2004, Month.APRIL, 29),
                    LocalDate.now().getYear() - 2004
            );
            Student bob = new Student(
                    "Bob", "bob@gmail.com",
                    LocalDate.of(2002, Month.JANUARY, 5),
                    LocalDate.now().getYear() - 2002
            );
            Student kevin = new Student(
                    "Kevin", "kevin@gmail.com",
                    LocalDate.of(2002, Month.JANUARY, 5),
                    LocalDate.now().getYear() - 2002
            );
            Student william = new Student(
                    "willam", "william@gmail.com",
                    LocalDate.of(2002, Month.JANUARY, 5),
                    LocalDate.now().getYear() - 2002
            );

            repository.saveAll(
                    List.of(mariam, alex, bob, kevin, william));
        };
    }
}
