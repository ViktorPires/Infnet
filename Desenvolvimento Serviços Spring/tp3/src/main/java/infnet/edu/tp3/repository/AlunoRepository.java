package infnet.edu.tp3.repository;

import infnet.edu.tp3.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
