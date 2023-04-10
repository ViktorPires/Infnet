package br.edu.infnet.appmecanica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmecanica.model.domain.Atendimento;
import br.edu.infnet.appmecanica.model.domain.Cliente;
import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.domain.Servico;
import br.edu.infnet.appmecanica.model.domain.Usuario;
import br.edu.infnet.appmecanica.model.service.AtendimentoService;


@Order(6)
@Component
public class AtendimentoLoader implements ApplicationRunner {

	@Autowired
	AtendimentoService atendimentoService;
	
	@Value("atendimentosLoader.txt")
	Resource resourceFile;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			
			String arq = "atendimentosLoader.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				
				String linha = leitura.readLine();
				
				String campos[] = null;
				
				while (linha != null) {
					
					campos = linha.split(";");

					Usuario usuario = new Usuario();
					usuario.setId(Integer.valueOf(campos[3]));
					
					List<Servico> servicos = new ArrayList<Servico>();
					for (String sid: campos[3].split(" ")) {
						Mecanica servico = new Mecanica();
						servico.setId(Integer.valueOf(sid));
						servicos.add(servico);
					}
					
					Cliente cliente = new Cliente();
					cliente.setId(Integer.valueOf(campos[1]));
					cliente.setNome(campos[2]);
					
					Atendimento atendimento = new Atendimento();
					atendimento.setCliente(cliente);
					atendimento.setServicos(servicos);
					atendimento.setUsuario(usuario);
					atendimento.setDescricao(campos[0]);
					atendimento.setMecanicoResponsavel(campos[4]);
					atendimentoService.incluir(atendimento);
					
					linha = leitura.readLine();
				}
				
				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("[Erro] DataLoader Atendimento - " +e.getMessage());
			}
		} finally {
			System.out.println("[Sucesso] DataLoader Atendimento");
		}
	}
}