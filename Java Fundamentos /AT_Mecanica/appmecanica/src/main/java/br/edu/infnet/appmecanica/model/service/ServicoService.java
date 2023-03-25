package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.model.domain.Servico;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.repository.IServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private IServicoRepository servicoRepository;
	
	public void excluir(Integer key) {
		servicoRepository.deleteById(key);
	}
	
	public Collection<Servico> obterLista() {
		return (Collection<Servico>) servicoRepository.findAll();
	}
	
	public Collection<Servico> obterLista(Usuario usuario) {
		return (Collection<Servico>) servicoRepository.obterLista(usuario.getId());
	}
	
	public Servico obterPorId(Integer id) {
		return servicoRepository.findById(id).orElse(null);
	}
}
