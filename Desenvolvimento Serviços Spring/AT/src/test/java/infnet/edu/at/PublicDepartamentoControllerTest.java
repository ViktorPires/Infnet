package infnet.edu.at;

import infnet.edu.at.model.Departamento;
import infnet.edu.at.model.Funcionario;
import infnet.edu.at.repository.DepartamentoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import infnet.edu.at.repository.FuncionarioRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PublicDepartamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @AfterEach
    public void tearDown() {
        departamentoRepository.deleteAll();
        funcionarioRepository.deleteAll();
    }

    @Test
    public void testBuscarTodosDepartamentos() throws Exception {
        Departamento departamento1 = departamentoRepository.save(new Departamento("Departamento 1", "Local 1"));
        Departamento departamento2 = departamentoRepository.save(new Departamento("Departamento 2", "Local 2"));

        mockMvc.perform(get("/departamentos")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(departamento1.getId()))
                .andExpect(jsonPath("$[1].id").value(departamento2.getId()));
    }

    @Test
    public void testBuscarDepartamentoPorId() throws Exception {
        Departamento departamento = new Departamento("Departamento Teste", "Local Teste");
        departamento = departamentoRepository.save(departamento);

        mockMvc.perform(get("/departamentos/" + departamento.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("Departamento Teste"));
    }

    @Test
    public void testBuscarDepartamentoPorIdNaoEncontrado() throws Exception {
        mockMvc.perform(get("/departamentos/9999")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testBuscarFuncionariosDoDepartamento() throws Exception {
        Departamento departamento = departamentoRepository.save(new Departamento("Departamento Teste", "Local Teste"));
        Funcionario funcionario1 = new Funcionario("Funcionário 1", "Endereço 1", "1234567890",
                "func1@email.com", LocalDate.of(1998, 4, 6), departamento);
        Funcionario funcionario2 = new Funcionario("Funcionário 2", "Endereço 2", "9876543210",
                "func2@email.com", LocalDate.of(2002, 6, 12), departamento);
        departamento.setFuncionarios(List.of(funcionario1, funcionario2));
        departamentoRepository.save(departamento);

        mockMvc.perform(get("/departamentos/" + departamento.getId() + "/funcionarios")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nome").value("Funcionário 1"))
                .andExpect(jsonPath("$[1].nome").value("Funcionário 2"));
    }
}