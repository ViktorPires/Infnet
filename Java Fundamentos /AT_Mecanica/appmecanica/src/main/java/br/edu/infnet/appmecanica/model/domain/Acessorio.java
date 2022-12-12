package br.edu.infnet.appmecanica.model.domain;

import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.AcessorioEmFaltaException;

public class Acessorio extends Servico {
	
	private String tipo;
	private String fabricante;
	private boolean acessorioOriginal;
	private boolean acessorioEstoque;
	
	public Acessorio(String nome, float orcamento, int codigoRegistro, String tipo, String fabricante, boolean acessorioOriginal, boolean acessorioEstoque) throws OrcamentoZeradoException {
		super(nome, orcamento, codigoRegistro);
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
		
		float valorAcessorio = acessorioOriginal ? 1000 : 350;
		
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
		sb.append(acessorioOriginal ? "Acessório Original" : "Acessório Alternativo");
		sb.append(";");
		sb.append(acessorioEstoque ? "Acessório em Estoque" : "Acessório em Falta");
		
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
	
	public void setAcessorioOriginal(boolean acessorioOriginal) {
		this.acessorioOriginal = acessorioOriginal;
	}

	public boolean isAcessorioEstoque() {
		return acessorioEstoque;
	}

	public void setAcessorioEstoque(boolean acessorioEstoque) {
		this.acessorioEstoque = acessorioEstoque;
	}
	
}
