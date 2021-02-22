package com.uns.api.Marca.entity;

import com.uns.api.Producto.entity.Producto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "marca" )
public class Marca {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id_marca",
	         updatable = false )
	private int id;
	
	@Column( name = "nombre",
	         length = 45,
	         nullable = false )
	private String nombre;
	
	@OneToMany( cascade = CascadeType.ALL,
	            mappedBy = "marca",
	            fetch = FetchType.LAZY )
	private List<Producto> productos;
	
	public Marca() {
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
		this.nombre = nombre != null && nombre.isEmpty() ? null : nombre;
	}
	
	public void setProductos( List<Producto> productos ) {
		this.productos = productos;
	}
}
