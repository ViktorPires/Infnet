package br.edu.infnet.appmecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.repository.IUsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	public Usuario autenticar(Usuario usuario) {
		return usuarioRepository.autenticacao(usuario.getEmail(), usuario.getSenha());
	}

	public Usuario incluir(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void excluir(Integer key) {
		usuarioRepository.deleteById(key);
	}
	
	public Collection<Usuario> obterLista() {
		return (Collection<Usuario>) usuarioRepository.findAll();
	}
}
