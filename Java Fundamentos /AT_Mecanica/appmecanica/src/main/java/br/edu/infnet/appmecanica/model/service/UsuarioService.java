package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public boolean incluir(Usuario usuario) {
		return usuarioRepository.incluir(usuario);
	}
	
	public Usuario excluir(Integer key) {
		return usuarioRepository.excluir(key);
	}
	
	public Collection<Usuario> obterLista() {
		return usuarioRepository.obterLista();
	}
}
