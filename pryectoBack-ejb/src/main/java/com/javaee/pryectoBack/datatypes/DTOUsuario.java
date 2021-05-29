package com.javaee.pryectoBack.datatypes;

import java.io.Serializable;

import com.javaee.pryectoBack.model.Usuario;

public class DTOUsuario implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idPersona;
	private String email;
	private String nombre;
	private String apellido;
	private String nickname;
	private String direccion;
	
	public DTOUsuario(String idPersona, String email, String nombre, String apellido, String nickname,
			String direccion) {
		super();
		this.idPersona = idPersona;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nickname = nickname;
		this.direccion = direccion;
	}
	
	public DTOUsuario() {
	}
	
	public DTOUsuario(Usuario usuario) {
		this.idPersona = usuario.getIdPersona();
		this.email = usuario.getEmail();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.nickname = usuario.getNickname();
		this.direccion = usuario.getDireccion();
	}

	public String getIdPersona() {
		return idPersona;
	}
	
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
