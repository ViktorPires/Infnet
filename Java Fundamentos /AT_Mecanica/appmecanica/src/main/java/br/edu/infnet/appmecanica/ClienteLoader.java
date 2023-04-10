package br.edu.infnet.appmecanica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import br.edu.infnet.appmecanica.model.domain.Cliente;
import br.edu.infnet.appmecanica.model.domain.Endereco;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.service.ClienteService;

@Order(2)
@Component
public class ClienteLoader implements ApplicationRunner {
	
	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			String arq = "clientes.txt";
			
			String arq2 = "enderecoClientes.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				
				FileReader fileR2 = new FileReader(arq2);
				BufferedReader leitura2 = new BufferedReader(fileR2);
				
				String linha = leitura.readLine();
				
				String linha2 = leitura2.readLine();
				
				String campos[] = null;
				
				String campos2[] = null;
				
				while(linha != null) {
					
					campos = linha.split(";");
					
					campos2 = linha2.split(";");
					
					Usuario usuario = new Usuario();
					usuario.setId(1);
					
					Endereco endereco = new Endereco(
							campos2[0],
							campos2[1],
							campos2[2],
							campos2[3],
							campos2[4],
							campos2[5]
							);
					
					Cliente cliente = new Cliente(
							campos[0], 
							campos[1], 
							campos[2], 
							campos[3], 
							Integer.valueOf(campos[4])
							);
					
					cliente.setUsuario(usuario);
					cliente.setEndereco(endereco);
					
					clienteService.incluir(cliente);
					
					System.out.println("A criação e inclusão do cliente " + cliente.getNome() + " foi realizada com sucesso!");
					
					linha = leitura.readLine();
					
					linha2 = leitura2.readLine();
				}
			
				leitura.close();
				leitura2.close();
				fileR.close();
				fileR2.close();
			} catch (IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			}
		} finally {
			System.out.println("Processamento de Cliente realizado com sucesso!!!");
		}	
	}
}
