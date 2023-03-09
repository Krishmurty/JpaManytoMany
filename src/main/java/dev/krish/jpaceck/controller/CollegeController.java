package dev.krish.jpaceck.controller;

import dev.krish.jpaceck.entity.Student;
import dev.krish.jpaceck.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/college")
public class CollegeController {
    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/student/add")
    ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student studentSaved = studentRepository.save(student);

        return ResponseEntity.ok().body(studentSaved);
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