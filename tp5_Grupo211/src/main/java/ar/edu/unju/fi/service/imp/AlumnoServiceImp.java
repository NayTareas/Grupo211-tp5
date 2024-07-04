package ar.edu.unju.fi.service.imp;
		
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.AlumnoService;

@Service

public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;
    
    @Override
    public void guardarAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public List<Alumno> mostrarAlumnos() {
        return alumnoRepository.findAll(); // Suponiendo que todos los alumnos tienen estado activo
    }

    @Override
    public void borrarAlumno(String dni) {
        List<Alumno> todosLosAlumnos = alumnoRepository.findAll();
        for (Alumno alumno : todosLosAlumnos) {
            if (alumno.getDni().equals(dni)) {
                alumnoRepository.delete(alumno);
                break;
            }
        }
    }

    @Override
    public void modificarAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public Alumno buscarAlumno(String dni) {
        return alumnoRepository.findById(dni).orElse(null);
    }
}
