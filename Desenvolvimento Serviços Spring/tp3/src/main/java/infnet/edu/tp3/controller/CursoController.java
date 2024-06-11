package infnet.edu.tp3.controller;

import infnet.edu.tp3.model.Aluno;
import infnet.edu.tp3.model.Curso;
import infnet.edu.tp3.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.buscarTodosCursos();
    }

    @GetMapping("/{id}")
    public Curso getCursoPorId(@PathVariable Long id) {
        return cursoService.buscarCursoPorId(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o id: " + id));
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.salvarCurso(curso);
    }

    @PutMapping("/{id}")
    public Curso updateCurso(@PathVariable Long id, @RequestBody Curso cursoUpdate) {
        return cursoService.atualizarCurso(id, cursoUpdate);
    }
    @PostMapping("/{id}/aluno")
    public Aluno addAlunoNoCurso(@PathVariable Long id, @RequestBody Aluno aluno) {
        return cursoService.addAlunoNoCurso(id, aluno);
    }

    @GetMapping("/{id}/alunos")
    public List<Aluno> buscarAlunosDoCurso(@PathVariable Long id) {
        return cursoService.buscarAlunosDoCurso(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        cursoService.deletarCursoPorId(id);
    }
}
