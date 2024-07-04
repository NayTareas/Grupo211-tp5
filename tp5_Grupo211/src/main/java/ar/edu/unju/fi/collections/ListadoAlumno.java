package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumno {
    public static List<Alumno> alumnos = new ArrayList<Alumno>();
    
    public static List<Alumno> listarAlumnos(){
        return alumnos;
    }
    
    public static Alumno buscarAlumnoPorCodigo(String codigo) {
        for (Alumno c : alumnos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null; // Devuelve null si no se encuentra el alumno con el código especificado
    }
}
