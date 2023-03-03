package br.edu.infnet.appmecanica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.service.UsuarioService;

@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		for (int i = 0; i < 5; i++) {
			Usuario usuario = new Usuario("Administrador" + i, "admin"+i+"@tester.com", "0"+i);
			usuario.setId(i);
			
			usuarioService.incluir(usuario);
			
			System.out.println("A criação e inclusão do usuário " + usuario.getNome() + " foi realizada com sucesso!");
		}
		
	}

}
