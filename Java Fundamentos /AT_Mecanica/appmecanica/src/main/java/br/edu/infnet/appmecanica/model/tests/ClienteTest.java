package br.edu.infnet.appmecanica.model.tests;

import br.edu.infnet.appmecanica.model.domain.Cliente;
import br.edu.infnet.appmecanica.model.exceptions.ClienteInvalidoException;

public class ClienteTest {

	public static void main(String[] args) {
		
		
		try {
			Cliente cliente1 = new Cliente("Pedrinho", "Rua do Barão, Porto Alegre", "51952524555", "Golf", 2021);
			System.out.println(cliente1);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente cliente2 = new Cliente(null, "Rua Leopoldina, Canoas", "519241236987", "Polo", 2019);
			System.out.println(cliente2);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Cliente cliente3 = new Cliente("Luizinho", "Rua do Gravataí, Viamão", "51952524555", null, 2018);
			System.out.println(cliente3);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Cliente cliente4 = new Cliente("Huguinho", null, "51952526755", "Onyx", 2018);
			System.out.println(cliente4);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Cliente cliente4 = new Cliente("Roberta", "Rua da República, Porto Alegre", null, "208", 2021);
			System.out.println(cliente4);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Cliente cliente5 = new Cliente("Zezinho", "Av. João Pessoa, Porto Alegre", "51952528799", "C3", 0);
			System.out.println(cliente5);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
	}

}
