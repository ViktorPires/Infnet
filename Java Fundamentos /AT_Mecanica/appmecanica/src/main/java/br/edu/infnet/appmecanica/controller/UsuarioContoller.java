package br.edu.infnet.appmecanica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.repository.UsuarioRepository;


@Controller
public class UsuarioContoller {	
	
	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@GetMapping(value = "/usuario/lista")
	public String telaLista() {
		
		List<Usuario> lista = UsuarioRepository.obterLista();
		
		System.out.println("Quantidade de usuários - " + lista.size());
		
		for(Usuario user : lista) {
			System.out.printf("%s - %s\n", user.getNome(), user.getEmail());
		}
		
		return "usuario/lista";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {
		
		UsuarioRepository.incluir(usuario);
		
		return "redirect:/usuario/lista";
	}
}
