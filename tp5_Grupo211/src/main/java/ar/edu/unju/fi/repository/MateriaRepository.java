package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.model.materia;

@Repository
public interface MateriaRepository extends JpaRepository <materia, String>{

	List<materia> findMateriaByEstado(Boolean estado);
}
