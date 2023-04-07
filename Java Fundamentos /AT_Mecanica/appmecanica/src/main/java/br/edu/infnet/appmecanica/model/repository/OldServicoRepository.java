package br.edu.infnet.appmecanica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.appmecanica.model.domain.Servico;

@Repository
public class OldServicoRepository {
	
	private static Integer id = 1;
	
	private static Map<Integer, Servico> mapaServico = new HashMap<Integer, Servico>();
	
	public boolean incluir(Servico servico) {
		
		servico.setId(id++);
		
		try {
			mapaServico.put(servico.getId(), servico);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Servico excluir(Integer chave) {
		return mapaServico.remove(chave);
	}
	
	public Collection<Servico> obterLista() {
		return mapaServico.values();
	}
}
