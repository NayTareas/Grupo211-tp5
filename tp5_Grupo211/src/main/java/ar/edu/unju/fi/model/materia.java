package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Data
@Component
@Entity


public class materia {

	@Id
	private String codigo;
	private String nombre;
	private String curso;
	private int cantHoras;
	private String modalidad;
	private Boolean estado;

}
