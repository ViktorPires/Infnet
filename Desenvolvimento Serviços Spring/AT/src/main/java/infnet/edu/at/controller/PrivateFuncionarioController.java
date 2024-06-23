package infnet.edu.at.controller;

import infnet.edu.at.model.Funcionario;
import infnet.edu.at.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/private/funcionarios")
public class PrivateFuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvarFuncionario(funcionario);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return funcionarioService.atualizarFuncionario(id, funcionario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarFuncionarioPorId(@PathVariable Long id) {
        funcionarioService.deletarFuncionarioPorId(id);
    }
}
