package br.edu.infnet.appmecanica.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmecanica.model.domain.Acessorio;

@Repository
public interface IAcessorioRepository extends CrudRepository<Acessorio, Integer> {

	@Query("from Acessorio a where a.usuario.id = :userId")
	List<Acessorio> obterLista(Integer userId);
}
