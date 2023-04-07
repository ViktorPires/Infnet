package br.edu.infnet.appmecanica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appmecanica.model.service.EnderecoService;

@Controller
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping(value = "/cep")
	public String buscaCep(Model model, @RequestParam String cep) {
		
	
		model.addAttribute("endereco", enderecoService.buscaPorCep(cep));
		
		return "usuario/cadastro";
	}
	
}
