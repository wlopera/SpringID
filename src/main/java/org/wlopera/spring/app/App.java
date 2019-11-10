package org.wlopera.spring.app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
		
		BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Uso de XML....................................................");
		System.out.println("Libro desde xml: " + factory.getBean("libro"));
		System.out.println("Autor desde xml: " + factory.getBean("autor"));
	        
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println("\nUso de Anotaciones....................................................");
		for (String value : context.getBeanDefinitionNames()) {
			System.out.println(value);
		}
		
		System.out.println("\nAutor: " + context.getBean(Autor.class).toString());
		System.out.println("Libro: " + context.getBean("libroService").toString());

		System.out.println("Autor: " + context.getBean(App.class).autor);
		System.out.println("Libro: " + context.getBean(App.class).libro);
		
		((ConfigurableApplicationContext)factory).close();
		((ConfigurableApplicationContext)context).close();
	}

	public static void main(String[] args) {

		App app = new App();
		app.init();
	}

}
