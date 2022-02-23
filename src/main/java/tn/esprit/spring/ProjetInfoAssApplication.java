package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
public class ProjetInfoAssApplication {

	public static void main(String[] args) {
		//ApplicationContext ctx= 
		SpringApplication.run(ProjetInfoAssApplication.class, args);
	}

}
