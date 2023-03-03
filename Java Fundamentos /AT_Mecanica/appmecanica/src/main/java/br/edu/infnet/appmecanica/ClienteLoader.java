package br.edu.infnet.appmecanica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmecanica.model.domain.Cliente;
import br.edu.infnet.appmecanica.model.service.ClienteService;

@Component
public class ClienteLoader implements ApplicationRunner {
	
	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Cliente cliente = new Cliente("Viktor", "Rua XXX, nº 1000, Cidade X", "51999999999", "C3", 2017);
		
		clienteService.incluir(cliente);
		
		System.out.println("A criação e inclusão do cliente " + cliente.getNome() + " foi realizada com sucesso!");
		
	}

	
}
