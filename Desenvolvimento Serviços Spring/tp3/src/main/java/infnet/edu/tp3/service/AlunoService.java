package infnet.edu.tp3.service;

import infnet.edu.tp3.model.Aluno;
import infnet.edu.tp3.model.Curso;
import infnet.edu.tp3.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Cacheable(value = "alunos")
    public List<Aluno> buscarTodosAlunos() {
        return alunoRepository.findAll();
    }

    @Cacheable(value = "alunos", key = "#id")
    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @CacheEvict(value = "alunos", key = "#id")
    public Aluno atualizarAluno(Long id, Aluno alunoUpdate) {
        return alunoRepository.findById(id).map(aluno -> {
            aluno.setNome(alunoUpdate.getNome());
            aluno.setEmail(alunoUpdate.getEmail());
            aluno.setCurso(alunoUpdate.getCurso());
            return alunoRepository.save(aluno);
        }).orElseGet(() -> {
            alunoUpdate.setId(id);
            return alunoRepository.save(alunoUpdate);
        });
    }

    @CacheEvict(value = "alunos", key = "#id")
    public void deletarAlunoPorId(Long id) {
        alunoRepository.deleteById(id);
    }
}
