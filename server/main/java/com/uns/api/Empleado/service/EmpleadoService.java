package com.uns.api.Empleado.service;

import com.uns.api.Empleado.entity.Empleado;
import com.uns.api.GeneralService;

import java.util.List;

public interface EmpleadoService extends GeneralService<Empleado, Integer> {
	
	List<Empleado> findEmployees( String filtro );
}
