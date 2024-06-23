package infnet.edu.at.service;

import infnet.edu.at.model.Usuario;
import infnet.edu.at.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(String id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setSenha(passwordEncoder.encode(usuarioAtualizado.getSenha()));
                    usuario.setPapel(usuarioAtualizado.getPapel());
                    return usuarioRepository.save(usuario);
                }).orElseGet(() -> {
                    usuarioAtualizado.setId(id);
                    return usuarioRepository.save(usuarioAtualizado);
                });
    }

    public void deletarUsuarioPorId(String id) {
        usuarioRepository.deleteById(id);
    }
}
