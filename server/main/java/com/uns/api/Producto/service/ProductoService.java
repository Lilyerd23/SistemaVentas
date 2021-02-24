package com.uns.api.Producto.service;

import com.uns.api.GeneralService;
import com.uns.api.Producto.entity.Producto;

import java.util.List;

public interface ProductoService extends GeneralService<Producto, Integer> {
	
	List<Producto> findProductos( String filtro );
	
	List<Producto> findByCategoria( Integer idCategoria );
	
	List<Producto> findByMarca( String flitroMarca );
}
