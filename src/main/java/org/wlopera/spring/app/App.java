package org.wlopera.spring.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.wlopera.spring.model.Autor;
import org.wlopera.spring.model.Libro;
@Component
public class App {

	@Autowired
	private Autor autor;

	@Autowired
	private Libro libro;

	public void init() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		for (String value : context.getBeanDefinitionNames()) {
			System.out.println(value);
		}
		
		System.out.println("Autor: " + context.getBean(Autor.class).toString());
		System.out.println("Libro: " + context.getBean("libroService").toString());

		System.out.println("Autor: " + context.getBean(App.class).autor);
		System.out.println("Libro: " + context.getBean(App.class).libro);
		
		((ConfigurableApplicationContext)context).close();
	}

	public static void main(String[] args) {

		App app = new App();
		app.init();
	}

}
