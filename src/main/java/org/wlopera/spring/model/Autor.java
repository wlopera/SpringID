package org.wlopera.spring.model;

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
public class Autor {
	private String nombre = "Luis";
    private String apellido = "Perez";
}
