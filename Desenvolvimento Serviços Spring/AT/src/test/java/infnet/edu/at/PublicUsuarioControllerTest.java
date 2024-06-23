package infnet.edu.at;

import infnet.edu.at.model.Usuario;
import infnet.edu.at.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PublicUsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @AfterEach
    public void tearDown() {
        usuarioRepository.deleteAll();
    }

    @Test
    public void testCriarUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("Novo Usuário");
        usuario.setSenha("senha123");
        usuario.setPapel("USUARIO");

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nome").value("Novo Usuário"))
                .andExpect(jsonPath("$.papel").value("USUARIO"));

        Usuario usuarioCriado = usuarioRepository.findUsuarioByNome("Novo Usuário");
        assert usuarioCriado != null;
    }
}