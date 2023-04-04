package br.edu.infnet.atapijavanuvem.model.repository;

import java.util.List;

import br.edu.infnet.atapijavanuvem.model.domain.DevedorPJ;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDevedorPJRepository extends CrudRepository<DevedorPJ, Integer> {

	List<DevedorPJ> findAll(Sort by);
	
	@Query("from DevedorPJ where ativo=true")
	List<DevedorPJ> obterAtivos();
}
