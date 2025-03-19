package com.pl.SystemCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.pl.SystemCRUD.Objects")
@EnableJpaRepositories("com.pl.SystemCRUD.Repositories")
@ComponentScan("com.pl.SystemCRUD")
public class SystemCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemCrudApplication.class, args);
	}

}
