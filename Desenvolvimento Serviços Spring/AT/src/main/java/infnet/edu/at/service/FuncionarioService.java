package infnet.edu.at.service;

import infnet.edu.at.model.Funcionario;
import infnet.edu.at.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionarioAtualizado) {
        return funcionarioRepository.findById(id)
                .map(funcionario -> {
                    funcionario.setNome(funcionarioAtualizado.getNome());
                    funcionario.setEndereco(funcionarioAtualizado.getEndereco());
                    funcionario.setTelefone(funcionarioAtualizado.getTelefone());
                    funcionario.setEmail(funcionarioAtualizado.getEmail());
                    funcionario.setDataNascimento(funcionarioAtualizado.getDataNascimento());
                    return funcionarioRepository.save(funcionario);
                }).orElseGet(() -> {
                    funcionarioAtualizado.setId(id);
                    return funcionarioRepository.save(funcionarioAtualizado);
                });
    }

    public void deletarFuncionarioPorId(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
