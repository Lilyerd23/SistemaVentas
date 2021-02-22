package com.uns.api.Categoria.entity;

import com.uns.api.Producto.entity.Producto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "categoria" )
public class Categoria {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id_categoria",
	         updatable = false )
	private int id;
	
	@Column( name = "nombre",
	         length = 45,
	         nullable = false )
	private String nombre;
	
	@OneToMany( cascade = CascadeType.ALL,
	            mappedBy = "categoria",
	            fetch = FetchType.LAZY )
	private List<Producto> productos;
	
	public Categoria() {
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
