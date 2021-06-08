package com.javaee.pryectoBack.data;

import javax.ejb.Local;

import com.javaee.pryectoBack.datatypes.DTOMultimedia;
import com.javaee.pryectoBack.datatypes.DTOUsuario;
import com.javaee.pryectoBack.datatypes.DTOUsuarioInicioSesion;

@Local
public interface ControladorUsuarioDALocal {
	DTOUsuario editarPerfil(DTOUsuario dtoUsuario);
	boolean registrarUsuario(DTOUsuario dtoUsuario);
	boolean subirFoto(String idPersona, DTOMultimedia dtoMultimedia);
	boolean agregarContacto(String idPersona, String idPersona2);
	boolean bajaContacto(String idPersona, String idPersona2);
	boolean eliminarCuenta(String idPersona);
	boolean bajaUsuarioAdmin(String idPersona);
	boolean modificarUsuarioAdmin(DTOUsuario dtoUsuario);
	boolean bloquearUsuario(String idPersona);
	boolean desbloquearUsuario(String idPersona);
	DTOUsuarioInicioSesion datosUsuarioInicioSesion(String idPersona);
}