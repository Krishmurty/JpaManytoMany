package dev.krish.jpaceck.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Set;
@ToString
@NoArgsConstructor

@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private
    Long id;

    @Column(nullable = false)
    private String courseName;
    @Column(nullable = false)
    private String dept;
    @ManyToMany(mappedBy = "likedCourses")
    @ToString.Exclude
    private Set<Student> likes;

    public Course(String courseName, String dept) {
        super();
        this.courseName = courseName;
        this.dept = dept;
    }
}
