package infnet.edu.at.controller;

import infnet.edu.at.model.Departamento;
import infnet.edu.at.model.Funcionario;
import infnet.edu.at.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class PublicDepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<Departamento> buscarTodosDepartamentos() {
        return departamentoService.listarTodosDepartamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarDepartamentoPorId(@PathVariable Long id) {
        return departamentoService.buscarDepartamentoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/funcionarios")
    public List<Funcionario> buscarFuncionariosDoDepartamento(@PathVariable Long id) {
        return departamentoService.buscarFuncionariosDoDepartamento(id);
    }
}
