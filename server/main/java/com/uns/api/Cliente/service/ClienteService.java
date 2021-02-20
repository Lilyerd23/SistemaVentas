package com.uns.api.Cliente.service;

import com.uns.api.Cliente.entity.Cliente;
import com.uns.api.GeneralService;

import java.util.List;

public interface ClienteService extends GeneralService<Cliente, Integer> {
	
	List<Cliente> findClients( String filtro );
}
