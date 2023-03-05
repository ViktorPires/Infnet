package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.model.domain.Funilaria;
import br.edu.infnet.appmecanica.model.repository.FunilariaRepository;

@Service
public class FunilariaService {
	
	@Autowired
	private FunilariaRepository funilariaRepository;

	public boolean incluir(Funilaria funilaria) {
		return funilariaRepository.incluir(funilaria);
	}
	
	public Funilaria excluir(Integer key) {
		return funilariaRepository.excluir(key);
	}
	
	public Collection<Funilaria> obterLista() {
		return funilariaRepository.obterLista();
	}
}
