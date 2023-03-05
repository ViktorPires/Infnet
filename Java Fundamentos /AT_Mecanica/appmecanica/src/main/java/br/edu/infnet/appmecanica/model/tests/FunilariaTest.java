package br.edu.infnet.appmecanica.model.tests;

import br.edu.infnet.appmecanica.model.domain.Funilaria;
import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.FunilariaInvalidoException;


public class FunilariaTest {

	public static void main(String[] args) {
		
		try {
			Funilaria funilaria1 = new Funilaria("Pintura da porta", 1450, "Tinta Azul", false, false, false, true);
			System.out.println("Valor do Orçamento: " + funilaria1.calcularValorOrcamento());
			System.out.println(funilaria1);
		} catch (OrcamentoZeradoException | FunilariaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Funilaria funilaria2 = new Funilaria("Polimento do Veículo", 1000, "Cera, Lixa, Pano Microfibra, Massa e Algodão", false, false, true, false);
			System.out.println("Valor do Orçamento: " + funilaria2.calcularValorOrcamento());
			System.out.println(funilaria2);
		} catch (OrcamentoZeradoException | FunilariaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Funilaria funilaria3 = new Funilaria("Lanternagem e pintura", 3000, "Tasso duplo e Tinta Vermelha", false, true, false, true);
			System.out.println("Valor do Orçamento: " + funilaria3.calcularValorOrcamento());
			System.out.println(funilaria3);
		} catch (OrcamentoZeradoException | FunilariaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
		
		try {
			Funilaria funilaria4 = new Funilaria("Martelinho", 2000, "Tasso triplo e Tinta Cinza", false, false, false, false);
			System.out.println("Valor do Orçamento: " + funilaria4.calcularValorOrcamento());
			System.out.println(funilaria4);
		} catch (OrcamentoZeradoException | FunilariaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
				
	}

}
