package br.edu.infnet.appmecanica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.service.MecanicaService;

@Order(3)
@Component
public class MecanicaLoader implements ApplicationRunner {
	
	@Autowired
	private MecanicaService mecanicaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			String arq = "mecanicas.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				
				String linha = leitura.readLine();
				
				String campos[] = null;
				
				while(linha != null) {
					
					campos = linha.split(";");
					
					Usuario usuarioAdmin = new Usuario();
					usuarioAdmin.setId(1);
					
					Mecanica mecanica = new Mecanica(
							campos[0], 
							Float.valueOf(campos[1]),
							campos[2], 
							Integer.valueOf(campos[3]), 
							campos[4],
							Boolean.valueOf(campos[5]),
							Integer.valueOf(campos[6])
							);
					
					mecanica.setUsuario(usuarioAdmin);
					
					mecanicaService.incluir(mecanica);
					
					System.out.println("A criação e inclusão do serviço de mecânica " + mecanica.getServico() + " foi realizada com sucesso!");
					
					linha = leitura.readLine();
				}
			
				leitura.close();
				fileR.close();
				
				System.out.println("Listagem de Mecânicas:");
				for(Mecanica mecanica : mecanicaService.obterLista()) {
					System.out.printf("%d - %s - %s\n",
							mecanica.getId(),
							mecanica.getServico(),
							mecanica.getCodigoRegistro(),
							mecanica.getOrcamento()
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
