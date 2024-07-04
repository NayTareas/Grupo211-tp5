package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.model.Materia;


@Service
public interface materiaService {

	public void guardarMateria(MateriaDTO materiaDTO);
	public List<Materia> mostrarMateria();
	public void borrarMateria(String codigo);
	public void modificarMateria(Materia materia);
	public Materia buscarMateria(String codigo);

}
