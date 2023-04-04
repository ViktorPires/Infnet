package br.edu.infnet.atapijavanuvem.model.repository;

import br.edu.infnet.atapijavanuvem.model.domain.DevedorPF;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDevedorPFRepository extends CrudRepository<DevedorPF, Integer> {

	List<DevedorPF> findAll(Sort by);
	
	@Query("from DevedorPF where ativo=true")
	List<DevedorPF> obterAtivos();
}
