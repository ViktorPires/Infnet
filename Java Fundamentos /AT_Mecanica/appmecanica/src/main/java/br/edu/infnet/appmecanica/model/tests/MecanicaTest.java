package br.edu.infnet.appmecanica.model.tests;

import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.QuantidadePecaInvalidoException;

public class MecanicaTest {

	public static void main(String[] args) {
		
		
		try {
			Mecanica mecanica1 = new Mecanica("Adicionar Turbina", 2500, "Turbo");
			mecanica1.setFabricante("Volkswagen");
			mecanica1.setQuantidade(1);
			mecanica1.setPecaNova(false);
			System.out.println("Orçamento: R$" + mecanica1.calcularValorOrcamento());
			System.out.println(mecanica1);
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Mecanica mecanica2 = new Mecanica("Trocar Pneu", 300, "Pneu");
			mecanica2.setFabricante("Volkswagen");
			mecanica2.setQuantidade(4);
			mecanica2.setPecaNova(true);
			System.out.println("Orçamento: R$" + mecanica2.calcularValorOrcamento());
			System.out.println(mecanica2);
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {	
			Mecanica mecanica3 = new Mecanica("Troca do Cárter", 2800, "Cárter");
			mecanica3.setFabricante("DHF");
			mecanica3.setPecaNova(false);
			mecanica3.setQuantidade(1);
			System.out.println("Orçamento: R$" + mecanica3.calcularValorOrcamento());
			System.out.println(mecanica3);
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {	
			Mecanica mecanica4 = new Mecanica("Troca do Alternador", 1200, "Alternador");
			mecanica4.setFabricante("Volkswagen");
			mecanica4.setQuantidade(0);
			mecanica4.setPecaNova(true);
			System.out.println("Orçamento: R$" + mecanica4.calcularValorOrcamento());
			System.out.println(mecanica4);
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {	
			Mecanica mecanica5 = new Mecanica("Troca de Bateria", 500, "Bateria");
			mecanica5.setFabricante("Moura");
			mecanica5.setQuantidade(-1);
			mecanica5.setPecaNova(true);
			System.out.println("Orçamento: R$" + mecanica5.calcularValorOrcamento());
			System.out.println(mecanica5);
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {	
			Mecanica mecanica6 = new Mecanica("Troca de Óleo", 0, "Óleo de Motor");
			mecanica6.setFabricante("Castrol");
			mecanica6.setQuantidade(1);
			mecanica6.setPecaNova(true);
			System.out.println("Orçamento: R$" + mecanica6.calcularValorOrcamento());
			System.out.println(mecanica6);
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}

}
