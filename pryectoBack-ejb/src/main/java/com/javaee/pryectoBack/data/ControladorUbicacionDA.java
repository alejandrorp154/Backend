package com.javaee.pryectoBack.data;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.javaee.pryectoBack.datatypes.DTOUbicacion;
import com.javaee.pryectoBack.model.Ubicacion;
import com.javaee.pryectoBack.model.Usuario;

@Singleton
public class ControladorUbicacionDA implements ControladorUbicacionDALocal, ControladorUbicacionDARemote {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Override
	public boolean alta(DTOUbicacion dtoUbicacion) {
		try {
			Usuario owner = manager.find(Usuario.class, dtoUbicacion.getIdPersona());
			if (owner != null) {
				Ubicacion ubicacion = new Ubicacion(dtoUbicacion);
				manager.persist(ubicacion);
				owner.getUbicaciones().add(ubicacion);
				manager.merge(owner);
				return true;
			}			
			return false;
		} catch (Exception exception) {
			return false;
		}
	}

	@Override
	public List<DTOUbicacion> obtenerUbicaciones(String idPersona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean baja(int idUbicacion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(DTOUbicacion dtoUbicacion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DTOUbicacion seleccionarUbicacion(int idUbicacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
