package br.edu.infnet.appmecanica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import br.edu.infnet.appmecanica.model.domain.Funilaria;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.service.FunilariaService;

@Order(4)
@Component
public class FunilariaLoader implements ApplicationRunner {
	
	@Autowired
	private FunilariaService funilariaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			String arq = "funilarias.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				
				String linha = leitura.readLine();
				
				String campos[] = null;
				
				while(linha != null) {
					
					campos = linha.split(";");
					
					Usuario usuarioAdmin = new Usuario();
					usuarioAdmin.setId(1);
					
					Funilaria funilaria = new Funilaria(
							campos[0],
							Float.valueOf(campos[1]),
							campos[2],
							Boolean.valueOf(campos[3]), 
							Boolean.valueOf(campos[4]), 
							Boolean.valueOf(campos[5]), 
							Boolean.valueOf(campos[6]),
							Integer.valueOf(campos[7])
							);
					
					funilaria.setUsuario(usuarioAdmin);
					
					funilariaService.incluir(funilaria);
					
					System.out.println("A criação e inclusão do serviço de funilaria " + funilaria.getServico() + " foi realizada com sucesso!");
					
					linha = leitura.readLine();
				}
			
				leitura.close();
				fileR.close();
				
				System.out.println("Listagem de Funilarias:");
				for(Funilaria funilaria : funilariaService.obterLista()) {
					System.out.printf("%d - %s - %s\n",
							funilaria.getId(),
							funilaria.getServico(),
							funilaria.getCodigoRegistro(),
							funilaria.getOrcamento()
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
