package dev.krish.jpaceck.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String emailId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @Column(nullable = false)
    @ToString.Exclude
    private Set<Course> likedCourses;

    public Student(String fname, String lname, String emailId) {
        super();
        this.firstname = fname;
        this.lastname = lname;
        this.emailId = emailId;
    }


}
