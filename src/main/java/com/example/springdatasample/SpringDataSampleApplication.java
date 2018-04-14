package com.example.springdatasample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootApplication
public class SpringDataSampleApplication {

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
