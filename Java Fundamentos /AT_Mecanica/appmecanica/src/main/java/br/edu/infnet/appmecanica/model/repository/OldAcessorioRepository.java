package br.edu.infnet.appmecanica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.appmecanica.model.domain.Acessorio;

@Repository
public class OldAcessorioRepository {
	
	private static Integer id = 1;
	
	private static Map<Integer, Acessorio> mapaAcessorio = new HashMap<Integer, Acessorio>();
	
	public boolean incluir(Acessorio acessorio) {
		
		acessorio.setId(id++);
		
		try {
			mapaAcessorio.put(acessorio.getId(), acessorio);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Acessorio excluir(Integer chave) {
		return mapaAcessorio.remove(chave);
	}
	
	public Collection<Acessorio> obterLista() {
		return mapaAcessorio.values();
	}
}
