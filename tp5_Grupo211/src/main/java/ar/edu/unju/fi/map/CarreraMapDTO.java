package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarreraMapDTO {
	

	@Mapping(target = "codigo", ignore = true)
	@Mapping(target = "estado", ignore = true)
	@Mapping(target = "nombre")
	@Mapping(target = "duracionCarrera", ignore = true)
	
	CarreraDTO convertirCarreraACarreraDTO(Carrera c);
	
	
	@InheritInverseConfiguration
	Carrera ConvertirCarreraDTOACarrera (CarreraDTO cdto);
	
	List<CarreraDTO> convertirListaCarrerasAListaCarrerasDTO (List<Carrera> ListaC);
	List<Carrera> convertirListaCarrerasDTOAListaCarreras (List<CarreraDTO> ListaCDTO);
}



