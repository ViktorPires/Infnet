package br.edu.infnet.appmecanica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmecanica.model.domain.Endereco;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.service.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			String arq = "endereco.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				
				String linha = leitura.readLine();
				
				String campos[] = null;
				
				int i = 1;
				
				while(linha != null) {
					
					campos = linha.split(";");
					
					Endereco endereco = new Endereco(
							campos[0], 
							campos[1], 
							campos[2], 
							campos[3], 
							campos[4],
							campos[5]
							); 
						
						Usuario usuario = new Usuario("Administrador" + i, "admin"+i+"@tester.com", "0"+i);
						usuario.setId(i);
						usuario.setAdmin(true);
						usuario.setEndereco(endereco);
						
						usuarioService.incluir(usuario);
						
						i++;
						
						System.out.println("A criação e inclusão do usuário " + usuario.getNome() + " foi realizada com sucesso!");	
				
						linha = leitura.readLine();
				}
			
				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			}
		} finally {
			System.out.println("Processamento de Usuário realizado com sucesso!!!");
		}	
		
	}

}
