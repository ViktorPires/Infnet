package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.model.domain.Acessorio;
import br.edu.infnet.appmecanica.model.domain.Funilaria;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.repository.IAcessorioRepository;

@Service
public class AcessorioService {
	
	@Autowired
	private IAcessorioRepository acessorioRepository;

	public Acessorio incluir(Acessorio acessorio) {
		return acessorioRepository.save(acessorio);
	}
	
	public void excluir(Integer key) {
		acessorioRepository.deleteById(key);
	}
	
	public Collection<Acessorio> obterLista() {
		return (Collection<Acessorio>) acessorioRepository.findAll();
	}
	
	public Collection<Acessorio> obterLista(Usuario usuario) {
		return (Collection<Acessorio>) acessorioRepository.obterLista(usuario.getId());
	}
	
	public Acessorio obterPorId(Integer id) {
		return acessorioRepository.findById(id).orElse(null);
	}
}
