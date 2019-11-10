package org.wlopera.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component
public class Libro {

	private String titulo = "Las dos chelitas";
	
	@Autowired
	private Autor autor;
	
	private String genero = "Hitoria";
	private String editorial = "Una";
	private int edicion = 2;
	private int paginas = 10;

}
