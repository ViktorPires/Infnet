package br.edu.infnet.appmecanica.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmecanica.model.domain.Atendimento;
import br.edu.infnet.appmecanica.model.domain.Mecanica;

@Repository
public interface IAtendimentoRepository extends CrudRepository<Atendimento, Integer> {
		
	@Query("from Atendimento a where a.usuario.id = :userId")
	List<Atendimento> obterLista(Integer userId);
}
