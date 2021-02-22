package com.uns.api.Producto.entity;

import com.uns.api.Categoria.entity.Categoria;
import com.uns.api.Marca.entity.Marca;

import javax.persistence.*;

@Entity
@Table( name = "producto" )
public class Producto {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id_producto",
	         updatable = false )
	private int id;
	
	@ManyToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "categoria_id",
	             foreignKey = @ForeignKey( name = "fk_categoria" ),
	             referencedColumnName = "id_categoria" )
	private Categoria categoria;
	
	@ManyToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "marca_id",
	             foreignKey = @ForeignKey( name = "fk_marca" ),
	             referencedColumnName = "id_marca" )
	private Marca marca;
	
	public Producto() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria( Categoria categoria ) {
		this.categoria = categoria;
	}
	
	public Marca getMarca() {
		return marca;
	}
	
	public void setMarca( Marca marca ) {
		this.marca = marca;
	}
}
