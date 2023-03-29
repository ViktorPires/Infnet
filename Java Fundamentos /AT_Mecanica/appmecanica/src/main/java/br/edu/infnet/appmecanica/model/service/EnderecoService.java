package br.edu.infnet.appmecanica.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.clients.IEnderecoClient;
import br.edu.infnet.appmecanica.model.domain.Endereco;

@Service
public class EnderecoService {

	private IEnderecoClient enderecoClient;
	
	 @Autowired
	 public EnderecoService(IEnderecoClient enderecoClient) {
	        this.enderecoClient = enderecoClient;
	    }
	
	public Endereco buscaPorCep(String cep) {
		
		return enderecoClient.buscaPorCep(cep);
	}
}
