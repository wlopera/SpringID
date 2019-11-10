# SpringID
INYECCION DE DEPENDENCIAS SPRING - JAVA

CODIGO:
------
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

SALIDA:
------
      Uso de XML....................................................
      Libro desde xml: Libro(titulo=Aprendiendo Spring, autor=Autor(nombre=Luis, apellido=Perez), genero=Aventuras, editorial=Una, edicion=2, paginas=257)
      Autor desde xml: Autor(nombre=Luis, apellido=Perez)

      Uso de Anotaciones....................................................
      org.springframework.context.annotation.internalConfigurationAnnotationProcessor
      org.springframework.context.annotation.internalAutowiredAnnotationProcessor
      org.springframework.context.event.internalEventListenerProcessor
      org.springframework.context.event.internalEventListenerFactory
      appConfig
      app
      autor
      libro
      libroService

      Autor: Autor(nombre=Luis, apellido=Perez)
      Libro: Libro(titulo=Las dos chelitas, autor=Autor(nombre=Luis, apellido=Perez), genero=Hitoria, editorial=Una, edicion=2, paginas=10)
      Autor: Autor(nombre=Luis, apellido=Perez)
      Libro: Libro(titulo=Las dos chelitas, autor=Autor(nombre=Luis, apellido=Perez), genero=Hitoria, editorial=Una, edicion=2, paginas=10)
