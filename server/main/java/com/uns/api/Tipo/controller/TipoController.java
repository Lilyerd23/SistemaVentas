package com.uns.api.Tipo.controller;

import com.uns.api.Cliente.entity.Cliente;
import com.uns.api.Tipo.entity.Tipo;
import com.uns.api.Tipo.service.TipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "/tipo",
                 produces = "application/json" )
@CrossOrigin( origins = "http://localhost:3000" )
public class TipoController {
	
	private final TipoService tipoService;
	
	public TipoController( TipoService tipoService ) {
		this.tipoService = tipoService;
	}
	
	@GetMapping( "/listar" )
	public ResponseEntity<List<Tipo>> listarTipos() {
		return new ResponseEntity<>( tipoService.listAll(),
		                             HttpStatus.OK );
	}
	
	@GetMapping( "/listar/{idTipo}" )
	public ResponseEntity<Tipo> buscarTipo( @PathVariable( "idTipo" ) Integer id ) {
		return new ResponseEntity<>( tipoService.findByID( id ),
		                             HttpStatus.OK );
	}
	
	@PostMapping( "/registrar" )
	public ResponseEntity<Tipo> registrarTipo( @RequestBody Tipo tipo ) {
		Tipo nuevo = tipoService.addNew( tipo );
		return new ResponseEntity<>( nuevo,
		                             HttpStatus.CREATED );
	}
	
	@PutMapping( "/actualizar" )
	public ResponseEntity<Tipo> actualizarTipo( @RequestBody Tipo tipo ) {
		Tipo actualizado = tipoService.update( tipo );
		return new ResponseEntity<>( actualizado,
		                             HttpStatus.OK );
	}
	
	@DeleteMapping( "/eliminar/{idTipo}" )
	public ResponseEntity<Tipo> eliminarTipo( @PathVariable( "idTipo" ) Integer id ) {
		tipoService.delete( id );
		return new ResponseEntity<>( null,
		                             HttpStatus.GONE );
	}
}
