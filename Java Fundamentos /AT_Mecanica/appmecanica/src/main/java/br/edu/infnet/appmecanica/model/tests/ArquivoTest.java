package br.edu.infnet.appmecanica.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appmecanica.model.domain.Acessorio;
import br.edu.infnet.appmecanica.model.domain.Atendimento;
import br.edu.infnet.appmecanica.model.domain.Cliente;
import br.edu.infnet.appmecanica.model.domain.Funilaria;
import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.domain.Servico;
import br.edu.infnet.appmecanica.model.exceptions.AtendimentoSemClienteException;
import br.edu.infnet.appmecanica.model.exceptions.AtendimentoSemServicoException;
import br.edu.infnet.appmecanica.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.appmecanica.model.exceptions.FunilariaInvalidoException;
import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.QuantidadePecaInvalidoException;


public class ArquivoTest {

	public static void main(String[] args) {
		
		try {
			String arq = "atendimentos.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				
				FileWriter fileW = new FileWriter("out_"+arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = leitura.readLine();
				
				String campos[] = null;
				
				List<Servico> servicosATDM = new ArrayList<Servico>();
				
				Atendimento atendimento = null;
				
				while(linha != null) {
					
					campos = linha.split(";");
					
					switch(campos[0].toUpperCase()) {
					
					case "A":
						try {
							atendimento = new Atendimento(new Cliente(campos[3], campos[4], campos[5], campos[6], Integer.valueOf(campos[7])), servicosATDM);
							atendimento.setDescricao(campos[1]);
							atendimento.setMecanicoResponsavel(campos[2]);
						} catch (ClienteInvalidoException | AtendimentoSemClienteException | AtendimentoSemServicoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}
						
						break;
					case "M":
						try {
							Mecanica mecanica = new Mecanica(campos[1], Float.valueOf(campos[2]), Integer.valueOf(campos[5]), campos[4]);
							mecanica.setFabricante(campos[6]);
							mecanica.setQuantidade(Integer.valueOf(campos[5]));
							mecanica.setPecaNova(Boolean.valueOf(campos[7]));
							
							servicosATDM.add(mecanica);
							
						} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}	
						break;
					case "F":
						try {
							Funilaria funilaria = new Funilaria(campos[1], Float.valueOf(campos[2]), campos[4], Boolean.valueOf(campos[5]), Boolean.valueOf(campos[6]), Boolean.valueOf(campos[7]), Boolean.valueOf(campos[8]));
							
							servicosATDM.add(funilaria);
						} catch (OrcamentoZeradoException | FunilariaInvalidoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}	
						break;
					case "AC":
						try {
							Acessorio acessorio = new Acessorio(campos[1], Float.valueOf(campos[2]), campos[4], campos[5], Boolean.valueOf(campos[6]), Boolean.valueOf(campos[7]));
							
							servicosATDM.add(acessorio);
						} catch (OrcamentoZeradoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}	
						break;
						
					default:
						System.out.println("Registro inválido!!!");
						break;
					}
					
					linha = leitura.readLine();
				}
				
				escrita.write(atendimento.obterLinhaArq());
				
				escrita.close();
				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			}
		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}	
	}
}
