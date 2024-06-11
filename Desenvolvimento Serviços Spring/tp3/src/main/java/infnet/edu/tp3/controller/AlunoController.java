package infnet.edu.tp3.controller;

import infnet.edu.tp3.model.Aluno;
import infnet.edu.tp3.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.buscarTodosAlunos();
    }

    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable Long id) {
        return alunoService.buscarAlunoPorId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o id: " + id));
    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.salvarAluno(aluno);
    }

    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno alunoUpdate) {
        return alunoService.atualizarAluno(id, alunoUpdate);
    }

    @PostMapping("/aluno/{alunoId}")

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id) {
        alunoService.deletarAlunoPorId(id);
    }
}