package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.model.domain.Atendimento;
import br.edu.infnet.appmecanica.model.repository.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;

	public boolean incluir(Atendimento atendimento) {
		return atendimentoRepository.incluir(atendimento);
	}
	
	public Atendimento excluir(Integer key) {
		return atendimentoRepository.excluir(key);
	}
	
	public Collection<Atendimento> obterLista() {
		return atendimentoRepository.obterLista();
	}
}
