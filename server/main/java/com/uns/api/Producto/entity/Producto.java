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
	
	@Column( name = "nombre",
	         length = 45,
	         nullable = false )
	private String nombre;
	
	@Column( name = "precio_compra",
	         columnDefinition = "DECIMAL(7,2)",
	         nullable = false )
	private Double precioCompra;
	
	@Column( name = "precio_venta",
	         columnDefinition = "DECIMAL(7,2)",
	         nullable = false )
	private Double precioVenta;
	
	@Column( name = "cantidad",
	         nullable = false )
	private int cantidad;
	
	@Column( name = "estado",
	         length = 45,
	         nullable = false )
	private String estado;
	
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
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre( String nombre ) {
		this.nombre = nombre;
	}
	
	public Double getPrecioCompra() {
		return precioCompra;
	}
	
	public void setPrecioCompra( Double precioCompra ) {
		this.precioCompra = precioCompra;
	}
	
	public Double getPrecioVenta() {
		return precioVenta;
	}
	
	public void setPrecioVenta( Double precioVenta ) {
		this.precioVenta = precioVenta;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad( int cantidad ) {
		this.cantidad = cantidad;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado( String estado ) {
		this.estado = estado;
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
