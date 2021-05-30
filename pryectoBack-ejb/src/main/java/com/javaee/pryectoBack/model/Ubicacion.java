package com.javaee.pryectoBack.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.javaee.pryectoBack.datatypes.DTOUbicacion;

@Entity
public class Ubicacion implements Serializable
{
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUbicacion;
	private float longitud;
	private float latitud;
	private Date fecha;
	private String descripcion;
	@ManyToOne
	private Usuario usuario;
	
	public Ubicacion() {
	}
	
	public Ubicacion(DTOUbicacion dtoUbicacion) {
		this.longitud = dtoUbicacion.getLongitud();
		this.latitud = dtoUbicacion.getLatitud();
		this.fecha = dtoUbicacion.getFecha();
		this.descripcion = dtoUbicacion.getDescripcion();
	}
	
	public int getIdUbicacion() {
		return idUbicacion;
	}
	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public DTOUbicacion getDTO() {
		return new DTOUbicacion(this.idUbicacion,this.longitud,this.latitud,this.fecha,this.descripcion);
	}
}
