package dev.krish.jpaceck;

import dev.krish.jpaceck.entity.Course;
import dev.krish.jpaceck.entity.Student;
import dev.krish.jpaceck.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpaceckApplication {
	private static final Logger log = LoggerFactory.getLogger(JpaceckApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(JpaceckApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(StudentRepository repository) {
		return (args) -> {
			// save a few customers
			Course course1 = new Course("Stats", "MathnScience");
			Course course2 = new Course("DataScience", "Computers");

			Student student1 = new Student("Krishna","Murty","k@gmail.com");
			Set<Course> courseSet1 = new HashSet<>();
			courseSet1.add(course1);
			courseSet1.add(course2);
			student1.setLikedCourses(courseSet1);

			repository.save(student1);
			/*repository.save(new Student("Chloe", "O'Brian"));
			repository.save(new Student("Kim", "Bauer"));
			repository.save(new Student("David", "Palmer"));
			repository.save(new Student("Michelle", "Dessler"));*/

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Student student : repository.findAll()) {
				log.info(student.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Student student = repository.findById(1L);
			Set<Course> courseList = student.getLikedCourses();
			courseList.stream().forEach(System.out::println);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(student.toString());
			log.info("##");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Murty'):");
			log.info("--------------------------------------------");
			repository.findByLastname("Murty").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}
}
