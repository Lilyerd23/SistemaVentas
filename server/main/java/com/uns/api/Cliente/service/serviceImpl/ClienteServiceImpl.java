package com.uns.api.Cliente.service.serviceImpl;

import com.uns.api.Cliente.entity.Cliente;
import com.uns.api.Cliente.repository.ClienteRepository;
import com.uns.api.Cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteServiceImpl( ClienteRepository clienteRepository ) {
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public List<Cliente> findClients( String filtro ) {
		List<Cliente> lista = new ArrayList<>();
		for ( Cliente buscados : clienteRepository.findAll() ) {
			if ( buscados.getDescripcion().contains( filtro ) ) {
				lista.add( buscados );
			}
		}
		return lista;
	}
	
	@Override
	public List<Cliente> listAll() {
		return clienteRepository.findAll();
	}
	
	@Override
	public Cliente findByID( Integer idCliente ) {
		return clienteRepository.findById( idCliente ).orElse( null );
	}
	
	@Override
	public Cliente addNew( Cliente cliente ) {
		Cliente           nuevo   = null;
		Optional<Cliente> buscado = clienteRepository.findByCodigo( cliente.getCodigo() );
		boolean           existe  = buscado.isPresent();
		if ( !existe ) {
			nuevo = clienteRepository.saveAndFlush( cliente );
		}
		return nuevo;
	}
	
	@Override
	public Cliente update( Cliente cliente ) {
		return clienteRepository.saveAndFlush( cliente );
	}
	
	@Override
	public void delete( Integer idCliente ) {
		clienteRepository.deleteById( idCliente );
	}
}
