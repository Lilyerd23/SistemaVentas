package com.uns.api.Producto.controller;

import com.uns.api.Producto.entity.Producto;
import com.uns.api.Producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "/producto",
                 produces = "application/json" )
@CrossOrigin( origins = "http://localhost:3000" )
public class ProductoController {
	
	private final ProductoService productoService;
	
	@Autowired
	public ProductoController( ProductoService productoService ) {
		this.productoService = productoService;
	}
	
	@GetMapping( "/listar" )
	public ResponseEntity<List<Producto>> listarProductos() {
		return new ResponseEntity<>( productoService.listAll(),
		                             HttpStatus.OK );
	}
	
	@GetMapping( "/buscar/{idProducto}" )
	public ResponseEntity<Producto> buscarProducto( @PathVariable( "idProducto" ) Integer id ) {
		return new ResponseEntity<>( productoService.findByID( id ),
		                             HttpStatus.FOUND );
	}
	
	@GetMapping( "/listar/{nombre}" )
	public ResponseEntity<List<Producto>> filtrarPorNombre( @PathVariable( "nombre" ) String filtroNombre ) {
		return new ResponseEntity<>( productoService.findProductos( filtroNombre ),
		                             HttpStatus.OK );
	}
	
	@GetMapping( "/listar/categoria/{idCategoria}" )
	public ResponseEntity<List<Producto>> listarPorCategoria( @PathVariable( "idCategoria" ) Integer id ) {
		return new ResponseEntity<>( productoService.findByCategoria( id ),
		                             HttpStatus.OK );
	}
	
	@GetMapping( "/listar/marca/{nombreMarca}" )
	public ResponseEntity<List<Producto>> filtrarPorMarca( @PathVariable( "nombreMarca" ) String filtroMarca ) {
		return new ResponseEntity<>( productoService.findByMarca( filtroMarca ),
		                             HttpStatus.OK );
	}
	
	@PostMapping( "/registrar" )
	public ResponseEntity<Producto> registrProducto( @RequestBody Producto producto ) {
		Producto nuevo = productoService.addNew( producto );
		return new ResponseEntity<>( nuevo,
		                             HttpStatus.CREATED );
	}
	
	@PutMapping( "/actualizar" )
	public ResponseEntity<Producto> actualizarProducto( @RequestBody Producto producto ) {
		Producto actualizado = productoService.update( producto );
		return new ResponseEntity<>( actualizado,
		                             HttpStatus.OK );
	}
	
	@DeleteMapping( "/eliminar/{idProducto}" )
	public ResponseEntity<Producto> eliminarProducto( @PathVariable( "idProducto" ) Integer id ) {
		productoService.delete( id );
		return new ResponseEntity<>( null,
		                             HttpStatus.GONE );
	}
}
