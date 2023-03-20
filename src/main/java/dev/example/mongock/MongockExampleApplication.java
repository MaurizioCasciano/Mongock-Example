package dev.example.mongock;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {
		UserDetailsServiceAutoConfiguration.class
})
@EnableMongock
public class MongockExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongockExampleApplication.class, args);
	}

}
