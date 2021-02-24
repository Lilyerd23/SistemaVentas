package com.uns.api.Producto.repository;

import com.uns.api.Producto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	@Query( "SELECT p FROM Producto p WHERE p.categoria.id = ?1" )
	List<Producto> porCategoria( Integer categoriaId );
}
