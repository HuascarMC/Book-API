package com.example.springdatasample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataSampleApplication.class, args);
	}

	@Entity // makes it a JPA entity.
	@Data	// does all the boiler plate for the class, setters for non final
	//fields/getters/toString/equals/hashCode/constructor that initializes all fields.
	@NoArgsConstructor // generates constructor with no parameters, just for the sake of JPA.
	class Book {
	   @Id // JPA recognizes this as the objects ID.
	   @GeneratedValue // to indicate that the ID should be generated automatically.
		 // title and description are left unnanotated, it is assumed they will be mapped to columns
		 // that share the same properties as the values themselves.
	   private Long id;
	   private String title;
	   private String description;
	   Book(String title, String description) {
	      this.title = title;
	      this.description = description;
	   }
	}
}
