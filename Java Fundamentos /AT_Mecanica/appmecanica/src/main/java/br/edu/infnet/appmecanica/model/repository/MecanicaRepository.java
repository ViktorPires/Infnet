package br.edu.infnet.appmecanica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.appmecanica.model.domain.Mecanica;

@Repository
public class MecanicaRepository {
	
	private static Integer codigoRegistro = 1;
	
	private static Map<Integer, Mecanica> mapaMecanica = new HashMap<Integer, Mecanica>();
	
	public boolean incluir(Mecanica mecanica) {
		
		mecanica.setCodigoRegistro(codigoRegistro++);
		
		try {
			mapaMecanica.put(mecanica.getCodigoRegistro(), mecanica);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Mecanica excluir(Integer chave) {
		return mapaMecanica.remove(chave);
	}
	
	public Collection<Mecanica> obterLista() {
		return mapaMecanica.values();
	}
}
