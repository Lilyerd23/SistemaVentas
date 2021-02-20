package com.uns.api.Tipo.service.serviceImpl;

import com.uns.api.Tipo.entity.Tipo;
import com.uns.api.Tipo.repository.TipoRepository;
import com.uns.api.Tipo.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TipoServiceImpl implements TipoService {
	
	private final TipoRepository tipoRepository;
	
	@Autowired
	public TipoServiceImpl( TipoRepository tipoRepository ) {
		this.tipoRepository = tipoRepository;
	}
	
	@Override
	public List<Tipo> listAll() {
		return tipoRepository.findAll();
	}
	
	@Override
	public Tipo findByID( Integer idTipo ) {
		return tipoRepository.findById( idTipo ).orElse( null );
	}
	
	@Override
	public Tipo addNew( Tipo tipo ) {
		Tipo           nuevo   = null;
		Optional<Tipo> buscado = tipoRepository.findByTipo( tipo.getTipo() );
		if ( tipo.getTipo() != null ) {
			boolean existe = buscado.isPresent();
			if ( !existe ) {
				nuevo = tipoRepository.saveAndFlush( tipo );
			}
		}
		return nuevo;
	}
	
	@Override
	public Tipo update( Tipo tipo ) {
		Tipo actualizado = null;
		Tipo find        = tipoRepository.findById( tipo.getId() ).orElseThrow();
		if ( !Objects.equals( find.getTipo(),
		                      tipo.getTipo() ) ) {
			Optional<Tipo> nombreTipo = tipoRepository.findByTipo( tipo.getTipo() );
			boolean existe = nombreTipo.isPresent();
			if ( !existe ) {
				actualizado = tipoRepository.saveAndFlush( tipo );
			}
		}
		return actualizado;
	}
	
	@Override
	public void delete( Integer idTipo ) {
		tipoRepository.deleteById( idTipo );
	}
}
