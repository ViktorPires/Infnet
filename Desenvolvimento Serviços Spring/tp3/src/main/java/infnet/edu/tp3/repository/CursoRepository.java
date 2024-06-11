package infnet.edu.tp3.repository;

import infnet.edu.tp3.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
