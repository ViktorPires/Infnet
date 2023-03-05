package br.edu.infnet.appmecanica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.service.MecanicaService;

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
					
					Mecanica mecanica = new Mecanica(
							campos[0], 
							Float.valueOf(campos[1]), 
							campos[2], 
							Integer.valueOf(campos[3]), 
							campos[4],
							Boolean.valueOf(campos[5])
							);
					
					mecanicaService.incluir(mecanica);
					
					System.out.println("A criação e inclusão do serviço de mecânica " + mecanica.getServico() + " foi realizada com sucesso!");
					
					linha = leitura.readLine();
				}
			
				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			}
		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}	
	}
}
