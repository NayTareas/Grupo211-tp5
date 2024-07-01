package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Docente5;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.DocenteService;

@Service

public class DocenteServiceImp implements DocenteService {

	@Autowired
	DocenteRepository docenteRepository;
	
	@Override
	public void guardarDocente(Docente5 docente) {
		// TODO Auto-generated method stub
		//docente.setEstado(true);
		docenteRepository.save(docente);
	}

	@Override
	public List<Docente5> mostarDocente() {
		// TODO Auto-generated method stub
		
		//return docenteRepository.findAll();
		return docenteRepository.findDocenteByEstado(true);
	}

	@Override
	public void borrarDocente(String legajo) {
		// TODO Auto-generated method stub
		System.out.println("este es el codigo: "+legajo);
		
		List<Docente5> todasLasDocentes = docenteRepository.findAll();
		for (int i = 0; i < todasLasDocentes.size(); i++) {
		      Docente5 docente = todasLasDocentes.get(i);
		      if (docente.getLegajo().equals(legajo)) {
		        docente.setEstado(false);
		        docenteRepository.save(docente);
		        break;
		      }
		    }
	}

	@Override
	public void midificarDocente(Docente5 docente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Docente5 buscarDocente(String legajo) {
		// TODO Auto-generated method stub
		return null;
	}




}
