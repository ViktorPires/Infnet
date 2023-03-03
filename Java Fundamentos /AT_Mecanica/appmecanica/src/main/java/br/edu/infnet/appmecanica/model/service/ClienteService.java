package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.model.domain.Cliente;
import br.edu.infnet.appmecanica.model.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public boolean incluir(Cliente cliente) {
		return clienteRepository.incluir(cliente);
	}
	
	public Cliente excluir(Integer key) {
		return clienteRepository.excluir(key);
	}
	
	public Collection<Cliente> obterLista() {
		return clienteRepository.obterLista();
	}
}
