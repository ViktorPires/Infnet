package br.edu.infnet.appmecanica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import br.edu.infnet.appmecanica.model.domain.Acessorio;
import br.edu.infnet.appmecanica.model.service.AcessorioService;

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
					
					Acessorio acessorio = new Acessorio(
							campos[0],
							Float.valueOf(campos[1]),
							campos[2],
							campos[3], 
							Boolean.valueOf(campos[4]), 
							Boolean.valueOf(campos[5])
							);
					
					acessorioService.incluir(acessorio);
					
					System.out.println("A criação e inclusão do serviço de acessório " + acessorio.getServico() + " foi realizada com sucesso!");
					
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