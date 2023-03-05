package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.repository.MecanicaRepository;

@Service
public class MecanicaService {
	
	@Autowired
	private MecanicaRepository mecanicaRepository;

	public boolean incluir(Mecanica mecanica) {
		return mecanicaRepository.incluir(mecanica);
	}
	
	public Mecanica excluir(Integer key) {
		return mecanicaRepository.excluir(key);
	}
	
	public Collection<Mecanica> obterLista() {
		return mecanicaRepository.obterLista();
	}
}
