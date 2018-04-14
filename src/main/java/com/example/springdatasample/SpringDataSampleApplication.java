package com.example.springdatasample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
public class SpringDataSampleApplication {


		@Bean
		CommandLineRunner initData(BookRepository bookRepository)	{
	   return args -> {
	      bookRepository.save(new Book("Spring Microservices", "Learn how to efficiently build and implement microservices in Spring,\n" +
	            "and how to use Docker and Mesos to push the boundaries. Examine a number of real-world use cases and hands-on code examples.\n" +
	            "Distribute your microservices in a completely new way"));
	      bookRepository.save(new Book("Pro Spring Boot", "A no-nonsense guide containing case studies and best practise for Spring Boot"));
	   };
		}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataSampleApplication.class, args);
	}
}

	@Entity
	@Data
	@NoArgsConstructor
	class Book {
	   @Id
	   @GeneratedValue
	   private Long id;
	   private String title;
	   private String description;
	   Book(String title, String description) {
	      this.title = title;
	      this.description = description;
	   }
	}

	@RepositoryRestResource
	interface  BookRepository extends CrudRepository {
	}
