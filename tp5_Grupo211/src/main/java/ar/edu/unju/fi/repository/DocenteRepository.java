package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Docente5;

@Repository
public interface DocenteRepository extends JpaRepository <Docente5, String >{

	//esta clase va a gestionar los ddatos con una bd

	List<Docente5> findDocenteByEstado(Boolean estado);

}
