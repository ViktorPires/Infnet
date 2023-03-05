package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.model.domain.Acessorio;
import br.edu.infnet.appmecanica.model.repository.AcessorioRepository;

@Service
public class AcessorioService {
	
	@Autowired
	private AcessorioRepository acessorioRepository;

	public boolean incluir(Acessorio acessorio) {
		return acessorioRepository.incluir(acessorio);
	}
	
	public Acessorio excluir(Integer key) {
		return acessorioRepository.excluir(key);
	}
	
	public Collection<Acessorio> obterLista() {
		return acessorioRepository.obterLista();
	}
}
