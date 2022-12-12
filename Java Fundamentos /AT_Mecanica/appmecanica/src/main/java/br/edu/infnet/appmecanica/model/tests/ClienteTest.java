package br.edu.infnet.appmecanica.model.tests;

import br.edu.infnet.appmecanica.model.domain.Cliente;

public class ClienteTest {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Pedrinho", "Rua do Barão, Porto Alegre", "51952524555", "Golf", 2021);
		System.out.println(cliente1);
		
		Cliente cliente2 = new Cliente("Zezinho", "Rua Leopoldina, Canoas", "519241236987", "Polo", 2019);
		System.out.println(cliente2);
		
		Cliente cliente3 = new Cliente("Luizinho", "Rua do Gravataí, Viamão", "51952524555", "Onyx", 2018);
		System.out.println(cliente3);
		
	}

}
