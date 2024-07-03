package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.model.Materia;

import ar.edu.unju.fi.service.materiaService;


@Controller
public class materiaController {

	@Autowired
	MateriaDTO nuevaMateriaDTO;
	
	@Autowired
	materiaService materiaService;
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		//vista formMateria.html
		ModelAndView modelView = new ModelAndView("formMateria");
		
		//agrega el objeto
		modelView.addObject("nuevaMateria", nuevaMateriaDTO);
		modelView.addObject("band", false);
		return modelView;
	}
	
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") MateriaDTO materiaparaGuardar) {
		
		//guardar
		
		materiaService.guardarMateria(materiaparaGuardar);
		
		//mostrar listado
		ModelAndView modelView = new ModelAndView("listadoDeMaterias");
		
		modelView.addObject("listadoMateria", materiaService.mostrarMateria());
		return modelView;
	}
	
	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView deleteMateriaDelListado(@PathVariable(name="codigo") String codigo) {
		//borrar
		System.out.println("este es el codigo: "+ codigo);
		materiaService.borrarMateria(codigo);
		//nuevo listado
		ModelAndView modelView = new ModelAndView("listadoDeMaterias");
		modelView.addObject("listadoMateria", materiaService.mostrarMateria());	
		
		return modelView;		
		}
}
