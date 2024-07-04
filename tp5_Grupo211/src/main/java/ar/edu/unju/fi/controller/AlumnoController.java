package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.AlumnoService;
import jakarta.validation.Valid;

@Controller
public class AlumnoController {
	
	@Autowired
	Alumno nuevoAlumno;
	
	@Autowired
	AlumnoService AlumnoService;
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		// Vista formAlumno.html
		ModelAndView modelView = new ModelAndView("formAlumno");
		// Agrega el objeto
		modelView.addObject("nuevoAlumno", nuevoAlumno);	
		modelView.addObject("band", false);
		return modelView;
	}
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@Valid @ModelAttribute("nuevoAlumno") Alumno alumnoParaGuardar, BindingResult resultado) {
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		if(resultado.hasErrors()) {
			modelView.setViewName("formAlumno");
		} else {
			// Guardar
			AlumnoService.guardarAlumno(alumnoParaGuardar);
			
			// Mostrar el listado
			modelView.setViewName("listaDeAlumnos");
			modelView.addObject("listadoAlumnos", AlumnoService.mostrarAlumnos());
		}
		return modelView;		
	}
	
	@GetMapping("/borrarAlumno/{dni}")
	public ModelAndView deleteAlumnoDelListado(@PathVariable(name="dni") String dni) {
		// Borrar
		AlumnoService.borrarAlumno(dni);
		
		// Mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", AlumnoService.mostrarAlumnos());	
		
		return modelView;		
	}

}