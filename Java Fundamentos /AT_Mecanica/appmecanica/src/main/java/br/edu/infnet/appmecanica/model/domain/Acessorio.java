package br.edu.infnet.appmecanica.model.domain;

import br.edu.infnet.appmecanica.model.auxiliar.Constante;
import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.AcessorioEmFaltaException;

public class Acessorio extends Servico {
	
	private String tipo;
	private String fabricante;
	private boolean acessorioOriginal;
	private boolean acessorioEstoque;
	
	public Acessorio(String servico, float orcamento, String tipo, String fabricante, boolean acessorioOriginal, boolean acessorioEstoque) throws OrcamentoZeradoException {
		super(servico, orcamento);
		this.tipo = tipo;
		this.fabricante = fabricante;
		this.acessorioOriginal = acessorioOriginal;
		this.acessorioEstoque = acessorioEstoque;	
	}
	
	@Override
	public float calcularValorOrcamento() throws AcessorioEmFaltaException {
		
		if(acessorioEstoque == false) {
			throw new AcessorioEmFaltaException("Acessório em falta no estoque!");
		}
		
		float valorAcessorio = acessorioOriginal ? Constante.ACESSORIO_ORIGINAL : Constante.ACESSORIO_ALTERNATIVO;
		
		return this.getOrcamento() + valorAcessorio;
	} 
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(tipo);
		sb.append(";");
		sb.append(fabricante);
		sb.append(";");
		sb.append(acessorioOriginal ? Constante.ACESSORIO_ORIGINAL_STR : Constante.ACESSORIO_ALTERNATIVO_STR);
		sb.append(";");
		sb.append(acessorioEstoque ? Constante.ACESSORIO_ESTOQUE_STR : Constante.ACESSORIO_FALTA_STR);
		
		return sb.toString();
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public boolean isAcessorioOriginal() {
		return acessorioOriginal;
	}
	
	public String getAcessorioOriginal() {
	    return acessorioOriginal ? "Sim" : "Não";
	}
	
	public void setAcessorioOriginal(boolean acessorioOriginal) {
		this.acessorioOriginal = acessorioOriginal;
	}

	public boolean isAcessorioEstoque() {
		return acessorioEstoque;
	}
	
	public String getAcessorioEstoque() {
	    return acessorioEstoque ? "Sim" : "Não - Encomendar";
	}

	public void setAcessorioEstoque(boolean acessorioEstoque) {
		this.acessorioEstoque = acessorioEstoque;
	}
	
}
