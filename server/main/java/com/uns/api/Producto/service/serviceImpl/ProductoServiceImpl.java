package com.uns.api.Producto.service.serviceImpl;

import com.uns.api.Producto.entity.Producto;
import com.uns.api.Producto.repository.ProductoRepository;
import com.uns.api.Producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	private final ProductoRepository productoRepository;
	
	@Autowired
	public ProductoServiceImpl( ProductoRepository productoRepository ) {
		this.productoRepository = productoRepository;
	}
	
	@Override
	public List<Producto> listAll() {
		return productoRepository.findAll();
	}
	
	@Override
	public Producto findByID( Integer idProducto ) {
		return productoRepository.findById( idProducto ).orElse( null );
	}
	
	@Override
	public Producto addNew( Producto producto ) {
		return productoRepository.saveAndFlush( producto );
	}
	
	@Override
	public Producto update( Producto producto ) {
		return productoRepository.saveAndFlush( producto );
	}
	
	@Override
	public void delete( Integer idMarca ) {
		productoRepository.deleteById( idMarca );
	}
	
	@Override
	public List<Producto> findProductos( String filtro ) {
		return productoRepository
				.findAll()
				.stream()
				.filter( producto -> producto.getNombre().contains( filtro ) )
				.collect( Collectors.toList() );
	}
	
	@Override
	public List<Producto> findByCategoria( String filtroCategoria ) {
		return productoRepository
				.findAll()
				.stream()
				.filter( producto -> producto.getCategoria().getNombre().contains( filtroCategoria ) )
				.collect( Collectors.toList() );
	}
	
	@Override
	public List<Producto> findByMarca( String filtroMarca ) {
		return productoRepository
				.findAll()
				.stream()
				.filter( producto -> producto.getMarca().getNombre().contains( filtroMarca ) )
				.collect( Collectors.toList() );
	}
}
