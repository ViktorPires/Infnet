package br.edu.infnet.appmecanica.model.tests;

import br.edu.infnet.appmecanica.model.domain.Acessorio;
import br.edu.infnet.appmecanica.model.domain.Atendimento;
import br.edu.infnet.appmecanica.model.domain.Cliente;
import br.edu.infnet.appmecanica.model.domain.Funilaria;
import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.domain.Servico;
import br.edu.infnet.appmecanica.model.exceptions.AcessorioEmFaltaException;
import br.edu.infnet.appmecanica.model.exceptions.AtendimentoSemClienteException;
import br.edu.infnet.appmecanica.model.exceptions.AtendimentoSemServicoException;
import br.edu.infnet.appmecanica.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.appmecanica.model.exceptions.FunilariaInvalidoException;
import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.QuantidadePecaInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class AtendimentoTest {

	public static void main(String[] args) {
		
		List<Servico> servicosATDM1 = new ArrayList<Servico>();
		List<Servico> servicosATDM2 = new ArrayList<Servico>();
		List<Servico> servicosATDM3 = new ArrayList<Servico>();
		List<Servico> servicosATDM4 = new ArrayList<Servico>();
	
		
		try {
			Mecanica mecanica1 = new Mecanica("Adicionar Turbina", 2500, 334265, "Turbo");
			mecanica1.setFabricante("Volkswagen");
			mecanica1.setQuantidade(1);
			mecanica1.setPecaNova(true);
			
			servicosATDM3.add(mecanica1);
			
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Mecanica mecanica2 = new Mecanica("Trocar Pneu", 300, 269918, "Pneu");
			mecanica2.setFabricante("Volkswagen");
			mecanica2.setQuantidade(4);
			mecanica2.setPecaNova(true);
			
			servicosATDM3.add(mecanica2);
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Mecanica mecanica3 = new Mecanica("Troca do Cárter", 2800, 241013, "Cárter");
			mecanica3.setQuantidade(1);
			mecanica3.setPecaNova(false);
			
			servicosATDM4.add(mecanica3);
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Funilaria funilaria1 = new Funilaria("Pintura da porta", 1450, "Tinta Azul", false, false, false, true, 336600);
			
			servicosATDM4.add(funilaria1);
		} catch (OrcamentoZeradoException | FunilariaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Funilaria funilaria2 = new Funilaria("Polimento do Veículo", 1000, "Cera, Lixa, Pano Microfibra, Massa e Algodão", false, false, true, false, 44568);
		
			servicosATDM2.add(funilaria2);
			servicosATDM4.add(funilaria2);
		} catch (OrcamentoZeradoException | FunilariaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Funilaria funilaria3 = new Funilaria("Lanternagem e pintura", 3000, "Tasso duplo e Tinta Vermelha", false, true, false, true, 242311);
			
			servicosATDM3.add(funilaria3);
		} catch (OrcamentoZeradoException | FunilariaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Acessorio acessorio1 = new Acessorio("Adicionar Pelicula", 1500, "Segurança", "3M", true, true, 249608);
			
			servicosATDM1.add(acessorio1);
			servicosATDM4.add(acessorio1);
		} catch (OrcamentoZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Acessorio acessorio2 = new Acessorio("Adicionar Caixas de Som", 2750, "Sonorização", "JBL", true, true, 811808);
			
			servicosATDM2.add(acessorio2);
			servicosATDM4.add(acessorio2);
		} catch (OrcamentoZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Acessorio acessorio3 = new Acessorio("Porta Bicicletas", 500, "Lazer", "Transbikes", false, false, 263329);
			
			servicosATDM3.add(acessorio3);
		} catch (OrcamentoZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	

		
		try {
			Atendimento atendimento1 = new Atendimento(new Cliente("Pedrinho", "Rua do Barão, Porto Alegre", "51952524555", "Golf", 2021), servicosATDM1);
			atendimento1.setDescricao("Primeiro Atendimento");
			atendimento1.setMecanicoResponsavel("Matheus");
			atendimento1.imprimir();
		} catch (ClienteInvalidoException | AtendimentoSemClienteException | AtendimentoSemServicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Atendimento atendimento2 = new Atendimento(new Cliente("Zezinho", "Rua Leopoldina, Canoas", "519241236987", "Polo", 2019), servicosATDM2); 
			atendimento2.setDescricao("Segundo Atendimento");
			atendimento2.setMecanicoResponsavel("João");
			atendimento2.imprimir();
		} catch (ClienteInvalidoException | AtendimentoSemClienteException | AtendimentoSemServicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		} 
		
		try {
			Atendimento atendimento3 = new Atendimento(new Cliente("Luizinho", "Rua do Gravataí, Viamão", "51952524555", "Onyx", 2018), servicosATDM3); 
			atendimento3.setDescricao("Terceiro Atendimento");
			atendimento3.setMecanicoResponsavel("Rogério");
			atendimento3.imprimir();
		} catch (ClienteInvalidoException | AtendimentoSemClienteException | AtendimentoSemServicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Atendimento atendimento4 = new Atendimento(new Cliente("Zezinho", "Av. João Pessoa, Porto Alegre", "51952528799", "C3", 2019), servicosATDM4); 
			atendimento4.setDescricao("Quarto Atendimento");
			atendimento4.setMecanicoResponsavel("Rogério");
			atendimento4.imprimir();
		} catch (ClienteInvalidoException | AtendimentoSemClienteException | AtendimentoSemServicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {			
			Atendimento atendimento5 = new Atendimento(null, servicosATDM4); 
			atendimento5.setDescricao("Quinto Atendimento");
			atendimento5.setMecanicoResponsavel("Rogério");
			atendimento5.imprimir();
		} catch (AtendimentoSemClienteException | AtendimentoSemServicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Cliente cliente6 = new Cliente("Roberta", "Rua da República, Porto Alegre", "51986237630", "208", 2021);
			
			Atendimento atendimento6 = new Atendimento(cliente6, null); 
			atendimento6.setDescricao("Quinto Atendimento");
			atendimento6.setMecanicoResponsavel("Rogério");
			atendimento6.imprimir();
		} catch (ClienteInvalidoException | AtendimentoSemClienteException | AtendimentoSemServicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
