package br.edu.infnet.appmecanica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appmecanica.model.domain.Mecanica;

public class MecanicaRepository {
	
	private static Integer codigoRegistro = 1;
	
	private static Map<Integer, Mecanica> mapaMecanica = new HashMap<Integer, Mecanica>();
	
	public static boolean incluir(Mecanica mecanica) {
		
		mecanica.setCodigoRegistro(codigoRegistro++);
		
		try {
			mapaMecanica.put(mecanica.getCodigoRegistro(), mecanica);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Mecanica excluir(Integer chave) {
		return mapaMecanica.remove(chave);
	}
	
	public static Collection<Mecanica> obterLista() {
		return mapaMecanica.values();
	}
}
