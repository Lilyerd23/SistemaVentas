package com.uns.api.Marca.repository;

import com.uns.api.Marca.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
	
	Optional<Marca> findByNombre( String nombre );
}
