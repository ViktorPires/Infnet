package br.edu.infnet.appmecanica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appmecanica.model.domain.Cliente;

public class ClienteRepository {
	
	private static Integer id = 1;
	
	private static Map<Integer, Cliente> mapaCliente = new HashMap<Integer, Cliente>();
	
	public static boolean incluir(Cliente cliente) {
		
		cliente.setId(id++);
		
		try {
			mapaCliente.put(cliente.getId(), cliente);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Cliente excluir(Integer chave) {
		return mapaCliente.remove(chave);
	}
	
	public static Collection<Cliente> obterLista() {
		return mapaCliente.values();
	}
}