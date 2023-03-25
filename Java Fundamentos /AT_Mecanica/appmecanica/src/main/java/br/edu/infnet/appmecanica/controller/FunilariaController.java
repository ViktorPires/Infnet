package br.edu.infnet.appmecanica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmecanica.model.domain.Funilaria;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.service.FunilariaService;


@Controller
public class FunilariaController {
	
	@Autowired
	private FunilariaService funilariaService;
	
	private String msg;
	
	@GetMapping(value = "/funilaria")
	public String telaCadastro() {
		return "funilaria/cadastro";
	}
	
	@GetMapping(value = "/funilaria/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("funilarias", funilariaService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "funilaria/lista";
	}
	
	@PostMapping(value = "/funilaria/incluir")
	public String incluir(Funilaria funilaria, @SessionAttribute("usuario") Usuario usuario) {
		
		funilaria.setUsuario(usuario);
		
		funilariaService.incluir(funilaria);
		
		msg = "A inclusão do serviço de funilaria " + funilaria.getServico() + " foi realizada com sucesso!";
		
		return "redirect:/funilaria/lista";
	}
	
	@GetMapping(value = "/funilaria/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Funilaria funilaria = funilariaService.obterPorId(id);
		
		funilariaService.excluir(id);
		
		msg = "A exclusão do serviço de funilaria " + funilaria.getServico() + " foi realizada com sucesso!";
		
		return "redirect:/funilaria/lista";
	}
}