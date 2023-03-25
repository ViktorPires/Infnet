package br.edu.infnet.appmecanica.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmecanica.model.domain.Funilaria;

@Repository
public interface IFunilariaRepository extends CrudRepository<Funilaria, Integer> {

	@Query("from Funilaria f where f.usuario.id = :userId")
	List<Funilaria> obterLista(Integer userId);
}
