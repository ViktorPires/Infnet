package br.edu.infnet.appmecanica.model.tests;

import br.edu.infnet.appmecanica.model.domain.Acessorio;
import br.edu.infnet.appmecanica.model.domain.Atendimento;
import br.edu.infnet.appmecanica.model.domain.Cliente;
import br.edu.infnet.appmecanica.model.domain.Funilaria;
import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.domain.Servico;
import br.edu.infnet.appmecanica.model.exceptions.AcessorioEmFaltaException;
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
			Mecanica mecanica1 = new Mecanica("Adicionar Turbina", 2500, 6546, "Turbo");
			mecanica1.setFabricante("Volkswagen");
			mecanica1.setQuantidade(1);
			mecanica1.setPecaNova(true);
			
			servicosATDM3.add(mecanica1);
			
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Mecanica mecanica2 = new Mecanica("Trocar Jogo de Pneus", 300, 6547, "Pneu");
			mecanica2.setFabricante("Volkswagen");
			mecanica2.setQuantidade(4);
			mecanica2.setPecaNova(true);
			
			servicosATDM3.add(mecanica2);
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Mecanica mecanica3 = new Mecanica("Troca do Cárter", 800, 6548, "Cárter");
			mecanica3.setFabricante("DHF");
			mecanica3.setQuantidade(1);
			mecanica3.setPecaNova(false);
			
			servicosATDM4.add(mecanica3);
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Funilaria funilaria1 = new Funilaria("Pintura da porta", 1450, 5648, "Tinta Azul", false, false, false, true);
			
			servicosATDM4.add(funilaria1);
		} catch (OrcamentoZeradoException | FunilariaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Funilaria funilaria2 = new Funilaria("Polimento do Veículo", 1000, 5649, "Cera, Lixa, Pano Microfibra, Massa e Algodão", false, false, true, false);
		
			servicosATDM2.add(funilaria2);
			servicosATDM4.add(funilaria2);
		} catch (OrcamentoZeradoException | FunilariaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Funilaria funilaria3 = new Funilaria("Lanternagem e pintura", 3000, 5650, "Tasso duplo e Tinta Vermelha", false, true, false, true);
			
			servicosATDM3.add(funilaria3);
		} catch (OrcamentoZeradoException | FunilariaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Acessorio acessorio1 = new Acessorio("Adicionar Película", 1500, 4248, "Segurança", "3M", true, true);
			
			servicosATDM1.add(acessorio1);
			servicosATDM4.add(acessorio1);
		} catch (OrcamentoZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Acessorio acessorio2 = new Acessorio("Adicionar Caixas de Som", 2750, 4249, "Sonorização", "JBL", true, true);
			
			servicosATDM2.add(acessorio2);
			servicosATDM4.add(acessorio2);
		} catch (OrcamentoZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Acessorio acessorio3 = new Acessorio("Porta Bicicletas", 500, 4250, "Lazer", "Transbikes", false, true);
			
			servicosATDM3.add(acessorio3);
		} catch (OrcamentoZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	

		
		try {
		Atendimento atendimento1 = new Atendimento();
		atendimento1.setDescricao("Primeiro Atendimento");
		atendimento1.setCliente(new Cliente("Pedrinho", "Rua do Barão, Porto Alegre", "51952524555", "Golf", 2021));
		atendimento1.setMecanicoResponsavel("Matheus");
		atendimento1.setServicos(servicosATDM1);
		atendimento1.imprimir();
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
		Atendimento atendimento2 = new Atendimento(); 
		atendimento2.setDescricao("Segundo Atendimento");
		atendimento2.setCliente(new Cliente("Zezinho", "Rua Leopoldina, Canoas", "519241236987", "Polo", 2019));
		atendimento2.setMecanicoResponsavel("João");
		atendimento2.setServicos(servicosATDM2);
		atendimento2.imprimir();
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		} 
		
		try {
		Atendimento atendimento3 = new Atendimento(); 
		atendimento3.setDescricao("Terceiro Atendimento");
		atendimento3.setCliente(new Cliente("Luizinho", "Rua do Gravataí, Viamão", "51952524555", "Onyx", 2018));
		atendimento3.setMecanicoResponsavel("Rogério");
		atendimento3.setServicos(servicosATDM3);
		atendimento3.imprimir();
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
		Atendimento atendimento4 = new Atendimento(); 
		atendimento4.setDescricao("Quarto Atendimento");
		atendimento4.setCliente(new Cliente("Zezinho", "Av. João Pessoa, Porto Alegre", "51952528799", "C3", 2019));
		atendimento4.setMecanicoResponsavel("Rogério");
		atendimento4.setServicos(servicosATDM4);
		atendimento4.imprimir();
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}

}
