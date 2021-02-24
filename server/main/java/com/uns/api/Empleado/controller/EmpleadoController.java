package com.uns.api.Empleado.controller;

import com.uns.api.Empleado.entity.Empleado;
import com.uns.api.Empleado.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "/empleado",
                 produces = "application/json" )
@CrossOrigin( origins = "http://localhost:3000" )
public class EmpleadoController {
	
	private final EmpleadoService empleadoService;
	
	@Autowired
	public EmpleadoController( EmpleadoService empleadoService ) {
		this.empleadoService = empleadoService;
	}
	
	@GetMapping( "/listar" )
	public ResponseEntity<List<Empleado>> listarEmpleados() {
		return new ResponseEntity<>( empleadoService.listAll(),
		                             HttpStatus.OK );
	}
	
	@GetMapping( "/buscar/{idEmpleado}" )
	public ResponseEntity<Empleado> buscarEmpleado( @PathVariable( "idEmpleado" ) Integer id ) {
		return new ResponseEntity<>( empleadoService.findByID( id ),
		                             HttpStatus.OK );
	}
	
	@GetMapping( "/listar/{nombreEmpleado}" )
	public ResponseEntity<List<Empleado>> filtrarEmpleados( @PathVariable( "nombreEmpleado" ) String filtro ) {
		return new ResponseEntity<>( empleadoService.findEmployees( filtro ),
		                             HttpStatus.OK );
	}
	
	@PostMapping( "/registrar" )
	public ResponseEntity<Empleado> registrarEmpleado( @RequestBody Empleado empleado ) {
		Empleado nuevo = empleadoService.addNew( empleado );
		return new ResponseEntity<>( nuevo,
		                             HttpStatus.CREATED );
	}
	
	@PostMapping( "/actualizar" )
	public ResponseEntity<Empleado> actualizarEmpleado( @RequestBody Empleado empleado ) {
		Empleado actualizado = empleadoService.update( empleado );
		return new ResponseEntity<>( actualizado,
		                             HttpStatus.OK );
	}
	
	@DeleteMapping( "/eliminar/{idEmpleado}" )
	public ResponseEntity<Empleado> eliminarEmpleado( @PathVariable( "idEmpleado" ) Integer id ) {
		empleadoService.delete( id );
		return new ResponseEntity<>( null,
		                             HttpStatus.GONE );
	}
}
