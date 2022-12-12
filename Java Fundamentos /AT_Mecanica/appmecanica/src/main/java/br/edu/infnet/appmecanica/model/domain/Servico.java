package br.edu.infnet.appmecanica.model.domain;

import br.edu.infnet.appmecanica.model.exceptions.AcessorioEmFaltaException;
import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.QuantidadePecaInvalidoException;

public abstract class Servico {
	
	private String nome;
	private float orcamento;
	private int codigoRegistro;
	

	public Servico(String nome, float orcamento, int codigoRegistro) throws OrcamentoZeradoException {
		
		if(orcamento == 0) {
			throw new OrcamentoZeradoException("O orçamento não pode estar zerado!");
		}
		
		if(orcamento < 0) {
			throw new OrcamentoZeradoException("O orcamento não pode ser negativo!");
		}
		
		this.nome = nome;
		this.orcamento = orcamento;
		this.codigoRegistro = codigoRegistro;
	}
	
	public abstract float calcularValorOrcamento() throws QuantidadePecaInvalidoException, AcessorioEmFaltaException;
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(orcamento);
		sb.append(";");
		sb.append(codigoRegistro);
		
		return sb.toString();
	}
	
	public String getNome() {
		return nome;
	}
	
	public float getOrcamento() {
		return orcamento;
	}
	
	public int getCodigoRegistro() {
		return codigoRegistro;
	}

}
