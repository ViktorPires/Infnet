package br.edu.infnet.appmecanica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.appmecanica.model.domain.Funilaria;

@Repository
public class OldFunilariaRepository {
	
	private static Integer id = 1;
	
	private static Map<Integer, Funilaria> mapaFunilaria = new HashMap<Integer, Funilaria>();
	
	public boolean incluir(Funilaria funilaria) {
		
		funilaria.setId(id++);
		
		try {
			mapaFunilaria.put(funilaria.getId(), funilaria);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Funilaria excluir(Integer chave) {
		return mapaFunilaria.remove(chave);
	}
	
	public Collection<Funilaria> obterLista() {
		return mapaFunilaria.values();
	}
}
