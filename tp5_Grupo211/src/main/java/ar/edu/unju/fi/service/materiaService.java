package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.model.materia;


@Service
public interface materiaService {

	public void guardarMateria(MateriaDTO materiaDTO);
	public List<materia> mostrarMateria();
	public void borrarMateria(String codigo);
	public void modificarMateria(materia materia);
	public materia buscarMateria(String codigo);

}
