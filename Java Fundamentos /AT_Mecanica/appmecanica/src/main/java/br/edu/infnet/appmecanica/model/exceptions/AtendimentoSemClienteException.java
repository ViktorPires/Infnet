package br.edu.infnet.appmecanica.model.exceptions;

public class AtendimentoSemClienteException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public AtendimentoSemClienteException(String mensagem) {
		super(mensagem);
	}

}
