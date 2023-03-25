package br.edu.infnet.appmecanica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import br.edu.infnet.appmecanica.model.domain.Acessorio;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.service.AcessorioService;

@Order(5)
@Component
public class AcessorioLoader implements ApplicationRunner {
	
	@Autowired
	private AcessorioService acessorioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			String arq = "acessorios.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				
				String linha = leitura.readLine();
				
				String campos[] = null;
				
				while(linha != null) {
					
					campos = linha.split(";");
					
					Usuario usuarioAdmin = new Usuario();
					usuarioAdmin.setId(1);
					
					Acessorio acessorio = new Acessorio(
							campos[0],
							Float.valueOf(campos[1]),
							campos[2],
							campos[3], 
							Boolean.valueOf(campos[4]), 
							Boolean.valueOf(campos[5]),
							Integer.valueOf(campos[6])
							);
					
					acessorio.setUsuario(usuarioAdmin);
					
					acessorioService.incluir(acessorio);
					
					System.out.println("A criação e inclusão do serviço de acessório " + acessorio.getServico() + " foi realizada com sucesso!");
					
					linha = leitura.readLine();
				}
			
				leitura.close();
				fileR.close();
				
				System.out.println("Listagem de Acessórios:");
				for(Acessorio acessorio : acessorioService.obterLista()) {
					System.out.printf("%d - %s - %s\n",
							acessorio.getId(),
							acessorio.getServico(),
							acessorio.getCodigoRegistro(),
							acessorio.getOrcamento()
					);
				}
			} catch (IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			}
		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}	
	}
}