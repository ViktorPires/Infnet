package br.edu.infnet.appmecanica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appmecanica.model.domain.Acessorio;
import br.edu.infnet.appmecanica.model.service.AcessorioService;


@Controller
public class AcessorioController {	
	
	@Autowired
	private AcessorioService acessorioService;
	
	private String msg;
	
	@GetMapping(value = "/acessorios")
	public String telaCadastro() {
		return "acessorios/cadastro";
	}
	
	@GetMapping(value = "/acessorios/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("acessorios", acessorioService.obterLista());
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "acessorios/lista";
	}
	
	@PostMapping(value = "/acessorios/incluir")
	public String incluir(Acessorio acessorio) {
		
		acessorioService.incluir(acessorio);
		
		msg = "A inclusão do serviço de acessório " + acessorio.getServico() + " foi realizada com sucesso!";
		
		return "redirect:/acessorios/lista";
	}
	
	@GetMapping(value = "/acessorios/{codigoRegistro}/excluir")
	public String excluir(@PathVariable Integer codigoRegistro) {
		
		Acessorio acessorio = acessorioService.excluir(codigoRegistro);
		
		msg = "A exclusão do serviço de acessório " + acessorio.getServico() + " foi realizada com sucesso!";
		
		return "redirect:/acessorios/lista";
	}
}