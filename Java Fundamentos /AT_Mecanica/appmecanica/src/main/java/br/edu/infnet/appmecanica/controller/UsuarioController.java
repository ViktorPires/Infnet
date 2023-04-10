package br.edu.infnet.appmecanica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appmecanica.model.domain.Endereco;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.service.UsuarioService;


@Controller
public class UsuarioController {	
	
	@Autowired
	private UsuarioService usuarioService;
	
	private String msg;
	
	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("usuarios", usuarioService.obterLista());
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "usuario/lista";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario, Endereco endereco) {
		
		usuario.setEndereco(endereco);
		
		usuarioService.incluir(usuario);
		
		msg = "A inclusão do usuário " + usuario.getNome() + " foi realizada com sucesso!";
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		try {
			usuarioService.excluir(id);
			
			msg = "A exclusão do usuário " + id + " foi realizada com sucesso!";
		} catch (Exception e) {
			msg = "Impossível realizar a exclusão do usuário " + id + "!";
		}
		
		return "redirect:/usuario/lista";
	}
}
