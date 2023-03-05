package br.edu.infnet.appmecanica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.appmecanica.model.domain.Funilaria;

@Repository
public class FunilariaRepository {
	
	private static Integer codigoRegistro = 1;
	
	private static Map<Integer, Funilaria> mapaFunilaria = new HashMap<Integer, Funilaria>();
	
	public boolean incluir(Funilaria funilaria) {
		
		funilaria.setCodigoRegistro(codigoRegistro++);
		
		try {
			mapaFunilaria.put(funilaria.getCodigoRegistro(), funilaria);
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
