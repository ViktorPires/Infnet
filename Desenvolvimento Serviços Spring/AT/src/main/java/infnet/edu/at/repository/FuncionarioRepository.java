package infnet.edu.at.repository;

import infnet.edu.at.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
