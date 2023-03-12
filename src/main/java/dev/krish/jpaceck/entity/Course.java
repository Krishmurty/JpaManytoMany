package dev.krish.jpaceck.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Set;

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
    @JsonIgnore
    @ManyToMany(mappedBy = "likedCourses")
    @ToString.Exclude
    private Set<Student> likes;

    public Course(){

    }
    public Course(String courseName, String dept) {
        super();
        this.courseName = courseName;
        this.dept = dept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Set<Student> getLikes() {
        return likes;
    }

    public void setLikes(Set<Student> likes) {
        this.likes = likes;
    }

   /* @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", dept='" + dept + '\'' +
                ", likes=" + likes +
                '}';
    }*/
}
