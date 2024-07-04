package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Entity
public class Alumno {
@Id
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String fechanacimiento;
	private String domicilio;
	private String LU;
	
	
	
}

