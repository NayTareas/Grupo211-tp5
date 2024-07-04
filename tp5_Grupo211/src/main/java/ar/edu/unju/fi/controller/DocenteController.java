package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.model.Docente5;
import ar.edu.unju.fi.service.DocenteService;
import jakarta.validation.Valid;

@Controller 

public class DocenteController {
		
		@Autowired
		Docente5 nuevaDocenteDTO;
		
		@Autowired
		DocenteService docenteService;
		

	@GetMapping({"/formularioDocenteIntento"})
		
		public ModelAndView getFormDocente() {
		//vista
		ModelAndView modelView =new ModelAndView ("formDocente");
		//agrega el objeto
		//comprobando el lombox
		//nuevaDocente.setNombre ("Arturo");
		modelView.addObject("nuevaDocente", nuevaDocenteDTO);
		modelView.addObject("band", false);
		return modelView;		
		}


	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente( @Valid @ModelAttribute("nuevaDocente") DocenteDTO docenteParaGuardar, BindingResult resultado ) {
		
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		if(resultado.hasErrors()) {
			modelView.setViewName("formDocente");
			//al error vuelvo al formulario de carrera
			}else {
		
				//Guardar
				//ListadoDocentes.agregarDocente(docenteParaGuardar);
				docenteService.guardarDocente(docenteParaGuardar);
				
				
				//Mostrar el listado
				modelView.setViewName("listaDeDocentes");
		//modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());	
		modelView.addObject("listadoDocentes", docenteService.mostarDocente());
			}	
		
		return modelView;
		
		//agregar el try y catch
		//añadir modificaciones en formulario 
	}

	
	  @GetMapping("/borrarDocente/{legajo}") 
	  public ModelAndView deleteDocenteDelListado(@PathVariable(name="legajo") String legajo) {
	  //Borrar 
	  //ListadoDocentes.eliminarDocente(legajo); //mostrar el nuevo listado
	   System.out.println("este es el codigo: "+ legajo);
   	   docenteService.borrarDocente (legajo);
		  
		  
	  ModelAndView modelView = new ModelAndView("listaDeDocentes");
	  modelView.addObject("listadoDocentes",  docenteService.mostarDocente());
	   
	 return modelView; 
	  }
	  
	 /* 
	 * @GetMapping("/modificarDocente/{legajo}") public ModelAndView
	 * editDocente(@PathVariable(name="legajo") String legajo) { //buscar Docente
	 * docenteParaModificar = ListadoDocentes.buscarDocentePorLegajo(legajo);
	 * 
	 * //mostrar el nuevo formulario ModelAndView modelView = new
	 * ModelAndView("formDocente"); modelView.addObject("nuevaDocente",
	 * docenteParaModificar); modelView.addObject("band", true); return modelView; }
	 * 
	 * @PostMapping("/modificarDocente") public ModelAndView
	 * updateDocente(@ModelAttribute("nuevaDocente") Docente docenteModificada) {
	 * 
	 * //guardar ListadoDocentes.modificarDocente(docenteModificada);
	 * 
	 * //mostrar el listado ModelAndView modelView = new
	 * ModelAndView("listaDeDocentes"); modelView.addObject("listadoDocentes",
	 * ListadoDocentes.listarDocentes());
	 * 
	 * return modelView; }
	 * 
	 */
}
