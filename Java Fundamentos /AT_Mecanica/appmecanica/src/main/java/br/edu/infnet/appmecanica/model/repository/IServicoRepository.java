package br.edu.infnet.appmecanica.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmecanica.model.domain.Servico;

@Repository
public interface IServicoRepository extends CrudRepository<Servico, Integer> {
	
	@Query("from Servico s where s.usuario.id = :userId")
	List<Servico> obterLista(Integer userId, Sort sort);
}
