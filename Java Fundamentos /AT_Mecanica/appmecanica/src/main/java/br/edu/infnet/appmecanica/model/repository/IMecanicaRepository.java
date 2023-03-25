package br.edu.infnet.appmecanica.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmecanica.model.domain.Mecanica;

@Repository
public interface IMecanicaRepository extends CrudRepository<Mecanica, Integer> {

	@Query("from Mecanica m where m.usuario.id = :userId")
	List<Mecanica> obterLista(Integer userId);
}
