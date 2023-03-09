package dev.krish.jpaceck.repository;

import dev.krish.jpaceck.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findById(long id);

    Set<Student> findByLastname(String lastname);
}
