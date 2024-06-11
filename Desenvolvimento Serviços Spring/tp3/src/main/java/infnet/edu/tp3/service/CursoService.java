package infnet.edu.tp3.service;

import infnet.edu.tp3.model.Aluno;
import infnet.edu.tp3.model.Curso;
import infnet.edu.tp3.repository.AlunoRepository;
import infnet.edu.tp3.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Cacheable(value = "cursos")
    public List<Curso> buscarTodosCursos() {
        return cursoRepository.findAll();
    }

    @Cacheable(value = "cursos", key = "#id")
    public Optional<Curso> buscarCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso salvarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @CacheEvict(value = "cursos", key = "#id")
    public Curso atualizarCurso(Long id, Curso cursoUpdate) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNome(cursoUpdate.getNome());
            curso.setAlunos(cursoUpdate.getAlunos());
            return cursoRepository.save(curso);
        }).orElseGet(() -> {
            cursoUpdate.setId(id);
            return cursoRepository.save(cursoUpdate);
        });
    }

    @CacheEvict(value = "cursos", key = "#id")
    public void deletarCursoPorId(Long id) {
        cursoRepository.deleteById(id);
    }

    @CacheEvict(value = "cursos", key = "#Id")
    public Aluno addAlunoNoCurso(@PathVariable Long cursoId, @RequestBody Aluno aluno) {
        return cursoRepository.findById(cursoId).map(curso -> {
            aluno.setCurso(curso);
            return alunoRepository.save(aluno);
        }).orElseThrow(() -> new RuntimeException("Curso não encontrado com id: " + cursoId));
    }

    @Cacheable(value = "cursos", key = "#id")
    public List<Aluno> buscarAlunosDoCurso(Long id) {
        return cursoRepository.findById(id).map(Curso::getAlunos)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com id: " + id));
    }
}
