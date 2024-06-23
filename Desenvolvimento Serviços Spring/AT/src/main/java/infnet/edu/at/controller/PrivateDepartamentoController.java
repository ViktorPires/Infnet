package infnet.edu.at.controller;

import infnet.edu.at.model.Departamento;
import infnet.edu.at.model.Funcionario;
import infnet.edu.at.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import infnet.edu.at.service.DepartamentoService;

@RestController
@RequestMapping("/private/departamentos")
public class PrivateDepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento criarDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.criarDepartamento(departamento);
    }

    @PostMapping("/{id}/funcionario")
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario criarEaddFuncionarioNoDepartamento(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return departamentoService.addFuncionarioNoDepartamento(id, funcionario);
    }

    @PostMapping("/{id}/funcionario/{funcionarioId}")
    @ResponseStatus(HttpStatus.OK)
    public Funcionario addFuncionarioNoDepartamento(@PathVariable Long id, @PathVariable Long funcionarioId) {
       return funcionarioService.buscarFuncionarioPorId(funcionarioId).map(funcionario -> {
            return departamentoService.addFuncionarioNoDepartamento(id, funcionario);
        }).orElseThrow(() -> new RuntimeException("Funcionário não encontrado com id: " + funcionarioId));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Departamento atualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
        return departamentoService.atualizarDepartamento(id, departamento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarDepartamentoPorId(@PathVariable Long id) {
        departamentoService.deletarDepartamentoPorId(id);
    }
}
