package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import jakarta.persistence.Entity;

@Data
@Component
@Entity


public class materia {

	@Id
	
	
	
	private String codigo;
	@Min(value=10, message="")
	@Max(50)
	private String nombre;
	private String curso;
	private int cantHoras;
	private String modalidad;
	private Boolean estado;

}
