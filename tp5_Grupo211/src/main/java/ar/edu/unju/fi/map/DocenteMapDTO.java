package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.model.Docente5;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)

public interface DocenteMapDTO {

	@Mapping(source="legajo", target="legajo")
	@Mapping(source="nombre", target="nombre")
	@Mapping(source="apellido", target="apellido")	
	@Mapping(source="estado", target="estado")
	
	DocenteDTO convertirDocenteADocenteDTO(Docente5 d);
		
	@InheritInverseConfiguration
	Docente5 convertirDocenteDTOADocente(DocenteDTO ddto);

	List<DocenteDTO> convertirListaDocentesAListaDocentesDTO (List<Docente5> listaD);
	
	List<Docente5> convertirListaDocentesDTPAListaDocentes (List<DocenteDTO> listaD);

}
