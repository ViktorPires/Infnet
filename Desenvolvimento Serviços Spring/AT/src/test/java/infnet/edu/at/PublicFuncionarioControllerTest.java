package infnet.edu.at;

import infnet.edu.at.model.Departamento;
import infnet.edu.at.model.Funcionario;
import infnet.edu.at.repository.DepartamentoRepository;
import infnet.edu.at.repository.FuncionarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PublicFuncionarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @AfterEach
    public void tearDown() {
        funcionarioRepository.deleteAll();
        departamentoRepository.deleteAll();
    }

    @Test
    public void testBuscarTodosFuncionarios() throws Exception {
        Departamento departamento = departamentoRepository.save(new Departamento("Departamento Teste", "Local Teste"));
        Funcionario funcionario1 = funcionarioRepository.save(new Funcionario("Funcionário 1", "Endereço 1", "1234567890",
                "func1@email.com", LocalDate.of(2000, 1, 1), departamento));
        Funcionario funcionario2 = funcionarioRepository.save(new Funcionario("Funcionário 2", "Endereço 2", "9876543210",
                "func2@email.com", LocalDate.of(1995, 5, 15), departamento));

        mockMvc.perform(get("/funcionarios")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(funcionario1.getId()))
                .andExpect(jsonPath("$[1].id").value(funcionario2.getId()));
    }

    @Test
    public void testBuscarFuncionarioPorId() throws Exception {
        Departamento departamento = departamentoRepository.save(new Departamento("Departamento Teste", "Local Teste"));
        Funcionario funcionario = funcionarioRepository.save(new Funcionario("Funcionário Teste", "Endereço Teste", "1234567890",
                "teste@email.com", LocalDate.of(2000, 1, 1), departamento));

        mockMvc.perform(get("/funcionarios/" + funcionario.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(funcionario.getId()))
                .andExpect(jsonPath("$.nome").value("Funcionário Teste"));
    }

    @Test
    public void testBuscarFuncionarioPorIdNaoEncontrado() throws Exception {
        mockMvc.perform(get("/funcionarios/9999")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}