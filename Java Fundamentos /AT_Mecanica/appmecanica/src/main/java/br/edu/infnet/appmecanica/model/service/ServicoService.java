package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	
	public Collection<Servico> obterListaServicosOrd(Usuario usuario) {
		return servicoRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "servico"));
	}
	
	public Collection<Servico> obterLista(Usuario usuario) {
		return servicoRepository.obterLista(usuario.getId(), Sort.by(Direction.DESC, "orcamento"));
	}
	
	public Servico obterPorId(Integer id) {
		return servicoRepository.findById(id).orElse(null);
	}
}
