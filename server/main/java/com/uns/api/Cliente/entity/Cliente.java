package com.uns.api.Cliente.entity;

import com.uns.api.Tipo.entity.Tipo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "cliente" )
public class Cliente {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id_cliente",
	         updatable = false )
	private int id;
	
	@Column( name = "descripcion",
	         length = 80,
	         nullable = false )
	private String descripcion;
	
	@Column( name = "codigo",
	         length = 10,
	         nullable = false )
	private String codigo;
	
	@Column( name = "estado",
	         length = 1,
	         nullable = false )
	private String estado;
	
	@Column( name = "fecha_registro",
	         nullable = false )
	@Temporal( TemporalType.DATE )
	private Date fecha_registro;
	
	@ManyToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "tipo_id",
	             foreignKey = @ForeignKey( name = "fk_tipo" ),
	             referencedColumnName = "id_tipo" )
	private Tipo tipo;
	
	public Cliente() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion( String descripcion ) {
		this.descripcion = descripcion;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo( String codigo ) {
		this.codigo = codigo;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado( String estado ) {
		this.estado = estado;
	}
	
	public Date getFecha_registro() {
		return fecha_registro;
	}
	
	public void setFecha_registro( Date fecha_registro ) {
		this.fecha_registro = fecha_registro;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo( Tipo tipo ) {
		this.tipo = tipo;
	}
}
