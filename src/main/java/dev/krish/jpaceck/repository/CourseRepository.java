package dev.krish.jpaceck.repository;

import dev.krish.jpaceck.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
