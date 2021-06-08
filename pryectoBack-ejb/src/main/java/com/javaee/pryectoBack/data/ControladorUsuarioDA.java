package com.javaee.pryectoBack.data;

import java.util.Date;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.javaee.pryectoBack.datatypes.DTOMultimedia;
import com.javaee.pryectoBack.datatypes.DTOUsuario;
import com.javaee.pryectoBack.model.PerfilUsuario;
import com.javaee.pryectoBack.model.Persona;
import com.javaee.pryectoBack.datatypes.DTOUsuarioInicioSesion;
import com.javaee.pryectoBack.model.Usuario;
import com.javaee.pryectoBack.model.UsuarioContacto;

@Singleton
public class ControladorUsuarioDA implements ControladorUsuarioDALocal, ControladorUsuarioDARemote {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	public ControladorUsuarioDA()
	{
	}

	@Override
	public DTOUsuario editarPerfil(DTOUsuario dtoUsuario) {
		DTOUsuario dtoUsuarioRes = new DTOUsuario();
		try{
			Usuario usuario = manager.find(Usuario.class, dtoUsuario.getIdPersona());
			if (usuario != null) {
				usuario.setNickname(dtoUsuario.getNickname());
				usuario.setDireccion(dtoUsuario.getDireccion());
				usuario.setCelular(dtoUsuario.getCelular());
				usuario.setNombre(dtoUsuario.getNombre());
				usuario.setApellido(dtoUsuario.getApellido());
				usuario.setEmail(dtoUsuario.getEmail());
				manager.merge(usuario);
				dtoUsuarioRes = new DTOUsuario(usuario);
			}
		}catch (Exception exception) {
			return dtoUsuarioRes;
		}
		return dtoUsuarioRes;
	}

	@Override
	public boolean registrarUsuario(DTOUsuario dtoUsuario) {
		try{
			Usuario user = new Usuario(dtoUsuario);
			user.getMedalla().setUsuario(user);
			user.getConfiguracion().setUsuario(user);
			PerfilUsuario perfil = new PerfilUsuario(user);
			user.setPerfil(perfil);
			manager.merge(user);
			return true;
		}catch (Exception exception) {
			return false;
		}
	}

	@Override
	public boolean subirFoto(String idPersona, DTOMultimedia dtoMultimedia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean agregarContacto(String idPersona, String idPersona2) {
		try{
			Persona user1 = manager.find(Usuario.class, idPersona);
			Persona user2 = manager.find(Usuario.class, idPersona2);
			if (user1 != null && user2 != null) {
				UsuarioContacto usuarioContacto = new UsuarioContacto();
				usuarioContacto.setIdPersona(idPersona);
				usuarioContacto.setContactoIdPersona(idPersona2);
				usuarioContacto.setFechaContactos(new Date());
				manager.persist(usuarioContacto);
				return true;
			}
			return false;
		}catch (Exception exception) {
			return false;
		}
	}

	@Override
	public boolean bajaContacto(String idPersona, String idPersona2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarCuenta(String idPersona) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaUsuarioAdmin(String idPersona) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarUsuarioAdmin(DTOUsuario dtoUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bloquearUsuario(String idPersona) {
		boolean quedoBloqueado;
			Usuario user = manager.find(Usuario.class, idPersona);
			if(user != null) {
				boolean estaBloqueado = user.getEstaBloqueado();
				if (!estaBloqueado) {
					user.setEstaBloqueado(true);
				}
				quedoBloqueado = true;
				manager.persist(user);
			} else {
				quedoBloqueado = false;
			}
		return quedoBloqueado;
	}

	@Override
	public boolean desbloquearUsuario(String idPersona) {
		// TODO Auto-generated method stub
		return false;

	}

	@Override
	public DTOUsuarioInicioSesion datosUsuarioInicioSesion(String idPersona){

		Usuario user = manager.find(Usuario.class, idPersona);

		if (user != null){
			String imagen = user.getPerfil().getImagenPerfil();
			return new DTOUsuarioInicioSesion(user.getIdPersona(), user.getEmail(), user.getNombre(), user.getApellido(), user.getNickname(), imagen);
		}
		return null;
	}
}
