package com.javaee.pryectoBack.data;

import java.util.List;

import javax.ejb.Local;

import com.javaee.pryectoBack.datatypes.DTOUbicacion;

@Local
public interface ControladorUbicacionDALocal {
	boolean alta(DTOUbicacion dtoUbicacion);
	List<DTOUbicacion> obtenerUbicaciones(String idPersona);
	boolean baja(int idUbicacion);
	boolean modificar(DTOUbicacion dtoUbicacion);
	DTOUbicacion seleccionarUbicacion(int idUbicacion);
}
