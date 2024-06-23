package infnet.edu.at.service;

import infnet.edu.at.model.Funcionario;
import infnet.edu.at.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infnet.edu.at.model.Departamento;
import infnet.edu.at.repository.DepartamentoRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Departamento> listarTodosDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> buscarDepartamentoPorId(Long id) {
        return departamentoRepository.findById(id);
    }

    public Departamento criarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento atualizarDepartamento(Long id, Departamento departamentoAtualizado) {
        return departamentoRepository.findById(id)
                .map(departamento -> {
                    departamento.setNome(departamentoAtualizado.getNome());
                    departamento.setLocal(departamentoAtualizado.getLocal());
                    return departamentoRepository.save(departamento);
                }).orElseGet(() -> {
                    departamentoAtualizado.setId(id);
                    return departamentoRepository.save(departamentoAtualizado);
                });
    }

    public void deletarDepartamentoPorId(Long id) {
        departamentoRepository.deleteById(id);
    }

    public Funcionario addFuncionarioNoDepartamento(@PathVariable Long departamentoId, @RequestBody Funcionario funcionario) {
        return departamentoRepository.findById(departamentoId).map(departamento -> {
            funcionario.setDepartamento(departamento);
            return funcionarioRepository.save(funcionario);
        }).orElseThrow(() -> new RuntimeException("Departamento não encontrado com id: " + departamentoId));
    }

    public List<Funcionario> buscarFuncionariosDoDepartamento(Long id) {
        return departamentoRepository.findById(id).map(Departamento::getFuncionarios)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado com id: " + id));
    }

}
