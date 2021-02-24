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
	
	@GetMapping("/buscar/{idEmpleado}")
	public ResponseEntity<Empleado> buscarEmpleado( @PathVariable( "idEmpleado" ) Integer id ) {
		return new ResponseEntity<>( empleadoService.findByID( id ),
		                             HttpStatus.OK );
	}
}
