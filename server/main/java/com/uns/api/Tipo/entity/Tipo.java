package com.uns.api.Tipo.entity;

import com.uns.api.Cliente.entity.Cliente;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "tipo" )
public class Tipo {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id_tipo",
	         updatable = false )
	private int id;
	
	@Column( name = "tipo",
	         length = 45,
	         nullable = false )
	private String tipo;
	
	@OneToMany( cascade = CascadeType.ALL,
	            mappedBy = "tipo",
	            fetch = FetchType.LAZY )
	private List<Cliente> clientes;
	
	public Tipo() {
	
	}
	
	public int getId() {
		return id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo( String tipo ) {
		this.tipo = tipo != null && tipo.isEmpty() ? null : tipo;
	}
	
	public void setClientes( List<Cliente> clientes ) {
		this.clientes = clientes;
	}
}
