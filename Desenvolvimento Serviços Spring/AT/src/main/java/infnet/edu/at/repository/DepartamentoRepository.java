package infnet.edu.at.repository;

import infnet.edu.at.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
