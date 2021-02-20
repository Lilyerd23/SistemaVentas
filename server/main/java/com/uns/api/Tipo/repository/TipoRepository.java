package com.uns.api.Tipo.repository;

import com.uns.api.Tipo.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer> {
	
	Optional<Tipo> findByTipo( String tipo );
}
