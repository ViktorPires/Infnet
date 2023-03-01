package br.edu.infnet.appmecanica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.repository.MecanicaRepository;


@Controller
public class MecanicaController {	
	
	private String msg;
	
	@GetMapping(value = "/mecanica")
	public String telaCadastro() {
		return "mecanica/cadastro";
	}
	
	@GetMapping(value = "/mecanica/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("mecanicas", MecanicaRepository.obterLista());
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "mecanica/lista";
	}
	
	@PostMapping(value = "/mecanica/incluir")
	public String incluir(Mecanica mecanica) {
		
		MecanicaRepository.incluir(mecanica);
		
		msg = "A inclusão do serviço de mecânica " + mecanica.getServico() + " foi realizada com sucesso!";
		
		return "redirect:/mecanica/lista";
	}
	
	@GetMapping(value = "/mecanica/{codigoRegistro}/excluir")
	public String excluir(@PathVariable Integer codigoRegistro) {
		
		Mecanica mecanica = MecanicaRepository.excluir(codigoRegistro);
		
		msg = "A exclusão do serviço de mecânica " + mecanica.getServico() + " foi realizada com sucesso!";
		
		return "redirect:/mecanica/lista";
	}
}