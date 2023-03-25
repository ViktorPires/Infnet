package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.model.domain.Funilaria;
import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.repository.IFunilariaRepository;

@Service
public class FunilariaService {
	
	@Autowired
	private IFunilariaRepository funilariaRepository;

	public Funilaria incluir(Funilaria funilaria) {
		return funilariaRepository.save(funilaria);
	}
	
	public void excluir(Integer key) {
		funilariaRepository.deleteById(key);
	}
	
	public Collection<Funilaria> obterLista() {
		return (Collection<Funilaria>) funilariaRepository.findAll();
	}
	
	public Collection<Funilaria> obterLista(Usuario usuario) {
		return (Collection<Funilaria>) funilariaRepository.obterLista(usuario.getId());
	}
	
	public Funilaria obterPorId(Integer id) {
		return funilariaRepository.findById(id).orElse(null);
	}
}
