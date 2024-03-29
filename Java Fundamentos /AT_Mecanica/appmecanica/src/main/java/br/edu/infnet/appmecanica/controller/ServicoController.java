package br.edu.infnet.appmecanica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmecanica.model.domain.Servico;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.service.ServicoService;


@Controller
public class ServicoController {	
	
	@Autowired
	private ServicoService servicoService;
	
	private String msg;
	
	@GetMapping(value = "/servicos/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("servicos", servicoService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "servicos/lista";
	}
		
	@GetMapping(value = "/servicos/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Servico servico = servicoService.obterPorId(id);
		
		try {
			servicoService.excluir(id);
			
			msg = "A exclusão do serviço " + servico.getServico() + " foi realizada com sucesso!";
		} catch (Exception e) {
			msg = "Impossível realizar a exclusão do serviço " + servico.getServico() + "!";
		}
		
		return "redirect:/servicos/lista";
	}
}