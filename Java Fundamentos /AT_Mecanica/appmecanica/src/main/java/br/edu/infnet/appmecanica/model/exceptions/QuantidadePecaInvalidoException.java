package br.edu.infnet.appmecanica.model.exceptions;

public class QuantidadePecaInvalidoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public QuantidadePecaInvalidoException(String mensagem) {
		super(mensagem);
	}

}
