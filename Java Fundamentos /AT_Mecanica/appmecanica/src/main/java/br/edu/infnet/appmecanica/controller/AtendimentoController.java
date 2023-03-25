package br.edu.infnet.appmecanica.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmecanica.model.domain.Atendimento;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.service.AcessorioService;
import br.edu.infnet.appmecanica.model.service.AtendimentoService;
import br.edu.infnet.appmecanica.model.service.ClienteService;
import br.edu.infnet.appmecanica.model.service.FunilariaService;
import br.edu.infnet.appmecanica.model.service.MecanicaService;

@Controller
public class AtendimentoController {	

	@Autowired
	private AtendimentoService atendimentoService;
	
	private String msg;
	
	@GetMapping(value = "/atendimentos")
	public String telaCadastro(Model model) {
	
		return "atendimentos/cadastro";
	}
	
	@GetMapping(value = "/atendimentos/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("atendimentos", atendimentoService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "atendimentos/lista";
	}
	
	@PostMapping(value = "/atendimentos/incluir")
	public String incluir(Atendimento atendimento, @SessionAttribute("usuario") Usuario usuario) {
		
		atendimento.setUsuario(usuario);
		
		atendimentoService.incluir(atendimento);
		
		msg = "A inclusão do atendimento " + atendimento.getDescricao() + " foi realizada com sucesso!";
		
		return "redirect:/atendimentos/lista";
	}
	
	@GetMapping(value = "/atendimentos/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Atendimento atendimento = atendimentoService.obterPorId(id);
		
		atendimentoService.excluir(id);
		
		msg = "A exclusão do atendimento " + atendimento.getDescricao() + " foi realizada com sucesso!";
		
		return "redirect:/atendimentos/lista";
	}
}