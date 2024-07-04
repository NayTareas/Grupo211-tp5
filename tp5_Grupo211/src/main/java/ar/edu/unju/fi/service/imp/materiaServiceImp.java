package ar.edu.unju.fi.service.imp;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.map.MateriaMapDTO;
import ar.edu.unju.fi.model.materia;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.materiaService;

@Service
public class materiaServiceImp implements materiaService{

	@Autowired
	MateriaRepository materiaRepository;
	
	@Autowired
	MateriaMapDTO materiaMapDTO;
	
	@Override
	public void guardarMateria(MateriaDTO materiaDTO) {
		// TODO Auto-generated method stub
		materiaRepository.save(materiaMapDTO.convertirListaMateriaDTOAListaMaterias(materiaDTO));
		//materiaRepository.save(materia);
	}
	
	@Override
	public List<materia> mostrarMateria() {
		// TODO Auto-generated method stub
		return materiaRepository.findMateriaByEstado(true);
		//return materiaMapDTO.convertirListaMateriaAListaMateriasDTO(materiaRepository.findMateriaByEstado(true));
	}
	
	@Override
	public void borrarMateria(String codigo) {
		// TODO Auto-generated method stub
		System.out.println("este es el codigo: "+codigo);
		List<materia> todasLasMaterias = materiaRepository.findAll();
		for (int i = 0; i < todasLasMaterias.size(); i++) {
		      materia materia = todasLasMaterias.get(i);
		      if (materia.getCodigo().equals(codigo)) {
		        materia.setEstado(false);
		        materiaRepository.save(materia);
		        break;
		      }
		    }

	}
	
	@Override
	public void modificarMateria(materia materia) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public materia buscarMateria(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
