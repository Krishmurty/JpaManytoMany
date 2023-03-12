package dev.krish.jpaceck.controller;

import dev.krish.jpaceck.entity.Student;
import dev.krish.jpaceck.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//https://www.baeldung.com/jpa-many-to-many

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/student/add")
    ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student studentSaved = studentRepository.save(student);
        return ResponseEntity.ok().body(studentSaved);
    }

    @GetMapping("/student/{id}")
    Optional<Student> getStudent(@PathVariable Long id){
        Optional<Student> studentSaved = studentRepository.findById(id);
        System.out.println(studentSaved.toString());
        return studentSaved;
    }

    @GetMapping("/")
    String checkUrl(){
        return "Hi Krishna!! You are on right URL.";
    }
}
/*
{
    "firstname": "Fname",
    "lastname": "Lname",
    "emailId": "abc@gmail.com",
    "likedCourses": [
        {
            "courseName": "Stats",
            "dept": "MathnScience"
        },
        {
            "courseName": "ML",
            "dept": "Computers"
        }
    ]
}
 */