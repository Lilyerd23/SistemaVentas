package com.uns.api.Producto.entity;

import javax.persistence.*;

@Entity
@Table( name = "producto" )
public class Producto {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id_producto",
	         updatable = false )
	private int id;
	
	public Producto() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
}
