package org.wlopera.spring.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.wlopera.spring.model.Autor;
import org.wlopera.spring.model.Libro;

@Configuration
@ComponentScan("org.wlopera.spring")
public class AppConfig {

	@Bean(name = "libroService")
	Libro libro() {
		return new Libro();
	}

	@Bean
	Autor autor() {
		return new Autor();
	}

}