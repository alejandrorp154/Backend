package com.javaee.pryectoBack.data;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.javaee.pryectoBack.datatypes.DTOEvento;
import com.javaee.pryectoBack.model.Evento;
import com.javaee.pryectoBack.model.Usuario;

@Singleton
public class ControladorEventoDA implements ControladorEventoDALocal, ControladorEventoDARemote {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Override
	public DTOEvento crearEvento(DTOEvento dtoEvento) {
		try {
			Evento evento = new Evento(dtoEvento);
			manager.persist(evento);
			Usuario owner = manager.find(Usuario.class, dtoEvento.getIdPersona());
			owner.getEventos().add(evento);
			evento.getUsuarios().add(owner);
			manager.merge(owner);	
			dtoEvento.setIdEvento(evento.getIdEvento());
			//Falta Agregar logica de puntos
			return dtoEvento;
		} catch (Exception exception) {
			return null;
		}
	}

	@Override
	public boolean eliminarEvento(int idEvento) {
		return false;
	}

	@Override
	public DTOEvento modificar(DTOEvento dtoEvento) {
		DTOEvento dtoEventoRes = new DTOEvento();
		try {
			Evento evento = manager.find(Evento.class, dtoEvento.getIdEvento());
			evento.setUbicacion(dtoEvento.getUbicacion());
			evento.setDescripcion(dtoEvento.getDescripcion());
			evento.setFechaInicio(dtoEvento.getFechaInicio());
			evento.setFechaFin(dtoEvento.getFechaFin());
			evento.setEstado(dtoEvento.getEstado());
			manager.merge(evento);
			dtoEventoRes = new DTOEvento(evento);
		} catch (Exception exception) {
			return dtoEventoRes;
		}
		return dtoEventoRes;
	}

	@Override
	public boolean agregarUsuario(int idEvento, String idPersona) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerUsuario(int idEvento, String idPersona) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dejar(int idEvento, String idPersona) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarChatEvento(int idEvento, int idChat) {
		// TODO Auto-generated method stub
		return false;
	}

}
