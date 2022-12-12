package br.edu.infnet.appmecanica.model.exceptions;

public class AcessorioEmFaltaException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public AcessorioEmFaltaException(String mensagem) {
		super(mensagem);
	}

}
