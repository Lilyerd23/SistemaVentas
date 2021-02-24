package com.uns.api.Empleado.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "empleado" )
public class Empleado {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id_empleado",
	         updatable = false )
	private int id;
	
	@Column( name = "nombre",
	         length = 45,
	         nullable = false )
	private String nombre;
	
	@Column( name = "apellido",
	         length = 45,
	         nullable = false )
	private String apellido;
	
	@Column( name = "telefono",
	         length = 9,
	         nullable = false )
	private String telefono;
	
	@Column( name = "estado",
	         length = 45,
	         nullable = false )
	private String estado;
	
	@Column( name = "fecha_registro",
	         nullable = false )
	@Temporal( TemporalType.DATE )
	private Date fechaRegistro;
	
	public Empleado() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre( String nombre ) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido( String apellido ) {
		this.apellido = apellido;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono( String telefono ) {
		this.telefono = telefono;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado( String estado ) {
		this.estado = estado;
	}
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	
	public void setFechaRegistro( Date fechaRegistro ) {
		this.fechaRegistro = fechaRegistro;
	}
}
