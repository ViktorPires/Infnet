package br.edu.infnet.appmecanica.model.tests;

import br.edu.infnet.appmecanica.model.domain.Acessorio;
import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.AcessorioEmFaltaException;


public class AcessorioTest {

	public static void main(String[] args) {
		
		try {
			Acessorio acessorio1 = new Acessorio("Adicionar Pelicula", 1500, "Segurança", "3M", true, true, 249608);
			System.out.println("Orçamento: R$" + acessorio1.calcularValorOrcamento());
			System.out.println(acessorio1);
		} catch (OrcamentoZeradoException | AcessorioEmFaltaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Acessorio acessorio2 = new Acessorio("Adicionar Caixas de Som", 2750, "Sonorização", "JBL", true, true, 811808);
			System.out.println("Orçamento: R$" + acessorio2.calcularValorOrcamento());
			System.out.println(acessorio2);
		} catch (OrcamentoZeradoException | AcessorioEmFaltaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Acessorio acessorio3 = new Acessorio("Porta Bicicletas", 500, "Lazer", "Transbikes", false, false, 263329);
			System.out.println(acessorio3);
			System.out.println("Orçamento: R$" + acessorio3.calcularValorOrcamento());
		} catch (OrcamentoZeradoException | AcessorioEmFaltaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Acessorio acessorio4 = new Acessorio("Bagageiro", 500, "Lazer", "Transbags", false, false, 002655);
			System.out.println(acessorio4);
			System.out.println("Orçamento: R$" + acessorio4.calcularValorOrcamento());
		} catch (OrcamentoZeradoException | AcessorioEmFaltaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
	}

}
