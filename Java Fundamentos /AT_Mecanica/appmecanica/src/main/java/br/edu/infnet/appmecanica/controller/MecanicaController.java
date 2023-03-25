package br.edu.infnet.appmecanica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.service.MecanicaService;


@Controller
public class MecanicaController {	
	
	@Autowired
	private MecanicaService mecanicaService;
	
	private String msg;
	
	@GetMapping(value = "/mecanica")
	public String telaCadastro() {
		return "mecanica/cadastro";
	}
	
	@GetMapping(value = "/mecanica/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("mecanicas", mecanicaService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "mecanica/lista";
	}
	
	@PostMapping(value = "/mecanica/incluir")
	public String incluir(Mecanica mecanica, @SessionAttribute("usuario") Usuario usuario) {
		
		mecanica.setUsuario(usuario);
		
		mecanicaService.incluir(mecanica);
		
		msg = "A inclusão do serviço de mecânica " + mecanica.getServico() + " foi realizada com sucesso!";
		
		return "redirect:/mecanica/lista";
	}
	
	@GetMapping(value = "/mecanica/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Mecanica mecanica = mecanicaService.obterPorId(id);
		
		mecanicaService.excluir(id);
		
		msg = "A exclusão do serviço de mecânica " + mecanica.getServico() + " foi realizada com sucesso!";
		
		return "redirect:/mecanica/lista";
	}
}