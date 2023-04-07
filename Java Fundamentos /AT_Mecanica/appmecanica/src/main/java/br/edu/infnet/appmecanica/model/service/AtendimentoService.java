package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.model.domain.Atendimento;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.repository.IAtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
	private IAtendimentoRepository atendimentoRepository;

	public Atendimento incluir(Atendimento atendimento) {
		return atendimentoRepository.save(atendimento);
	}
	
	public void excluir(Integer key) {
		atendimentoRepository.deleteById(key);
	}
	
	public Collection<Atendimento> obterLista() {
		return (Collection<Atendimento>) atendimentoRepository.findAll();
	}
	
	public Collection<Atendimento> obterLista(Usuario usuario) {
		return (Collection<Atendimento>) atendimentoRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "descricao"));
	}
	
	public Atendimento obterPorId(Integer id) {
		return atendimentoRepository.findById(id).orElse(null);
	}
}
