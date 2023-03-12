package br.edu.infnet.appmecanica.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmecanica.model.domain.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	@Query("from Usuario user where user.email = :email and user.senha = :senha")
	Usuario autenticacao(String email, String senha);
}
