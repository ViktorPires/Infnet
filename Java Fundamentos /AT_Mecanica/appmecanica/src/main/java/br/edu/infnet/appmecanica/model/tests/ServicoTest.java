package br.edu.infnet.appmecanica.model.tests;

import br.edu.infnet.appmecanica.model.domain.Acessorio;
import br.edu.infnet.appmecanica.model.domain.Funilaria;
import br.edu.infnet.appmecanica.model.domain.Mecanica;
import br.edu.infnet.appmecanica.model.exceptions.AcessorioEmFaltaException;
import br.edu.infnet.appmecanica.model.exceptions.FunilariaInvalidoException;
import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.QuantidadePecaInvalidoException;

public class ServicoTest {

	public static void main(String[] args) {
		
		try {
			Mecanica mecanica1 = new Mecanica("Adicionar Turbina", 2500, "Turbo");
			mecanica1.setFabricante("Volkswagen");
			mecanica1.setQuantidade(1);
			mecanica1.setPecaNova(true);
			System.out.println("Orçamento: R$" + mecanica1.calcularValorOrcamento());
			System.out.println(mecanica1);
		} catch (OrcamentoZeradoException | QuantidadePecaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	
		try {
			Funilaria funilaria2 = new Funilaria("Polimento do Veículo", 1000, "Cera, Lixa, Pano Microfibra, Massa e Algodão", false, false, true, false);
			System.out.println("Orçamento: R$" + funilaria2.calcularValorOrcamento());
			System.out.println(funilaria2);
		} catch (OrcamentoZeradoException | FunilariaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Acessorio acessorio1 = new Acessorio("Adicionar Pelicula", 1500, "Segurança", "3M", true, true);
			System.out.println("Orçamento: R$" + acessorio1.calcularValorOrcamento());
			System.out.println(acessorio1);
		} catch (OrcamentoZeradoException | AcessorioEmFaltaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}	
	}
}
