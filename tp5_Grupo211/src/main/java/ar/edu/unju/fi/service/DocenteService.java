package ar.edu.unju.fi.service;

import java.util.List;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.model.Docente5;


@Service
public interface DocenteService {

	public void guardarDocente(DocenteDTO docenteDTO);
	public List<Docente5> mostarDocente();
	public void borrarDocente (String legajo);
	public void midificarDocente (Docente5 docente);
	public Docente5 buscarDocente (String legajo);
	
	//me brinda todos los servicios que tengo que hacer con una clase de modelos de datos
}
