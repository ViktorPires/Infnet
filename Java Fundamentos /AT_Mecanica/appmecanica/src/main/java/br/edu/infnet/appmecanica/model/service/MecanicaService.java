package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.repository.IMecanicaRepository;

@Service
public class MecanicaService {
	
	@Autowired
	private IMecanicaRepository mecanicaRepository;

	public Mecanica incluir(Mecanica mecanica) {
		return mecanicaRepository.save(mecanica);
	}
	
	public void excluir(Integer key) {
		mecanicaRepository.deleteById(key);
	}
	
	public Collection<Mecanica> obterLista() {
		return (Collection<Mecanica>) mecanicaRepository.findAll();
	}
	
	public Collection<Mecanica> obterLista(Usuario usuario) {
		return (Collection<Mecanica>) mecanicaRepository.obterLista(usuario.getId());
	}
	
	public Mecanica obterPorId(Integer id) {
		return mecanicaRepository.findById(id).orElse(null);
	}
}
