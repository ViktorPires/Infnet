package br.edu.infnet.appmecanica.model.domain;

import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.QuantidadePecaInvalidoException;

public class Mecanica extends Servico {

	private String peca;
	private int quantidade;
	private String fabricante;
	private boolean pecaNova;
	
	public Mecanica(String nome, float orcamento, int id, String peca) throws OrcamentoZeradoException {
		super(nome, orcamento, id);
		this.peca = peca;
	}	
	
	@Override
	public float calcularValorOrcamento() throws QuantidadePecaInvalidoException {
		
		if(quantidade == 0) {
			throw new QuantidadePecaInvalidoException("A quantidade de peça não pode ser zero!");
		}
		
		if(quantidade < 0) {
			throw new QuantidadePecaInvalidoException("A quantidade de peça não pode ser negativa!");
		}
		
		float valorPeca = pecaNova ? 1500 : 500;
		
	float valorFinal = 0;
		
		if(quantidade > 1) {
			valorFinal = this.getOrcamento() + valorPeca + ((quantidade - 1) * this.getOrcamento() / 3);
		} else if(quantidade == 1){
			valorFinal = this.getOrcamento() + valorPeca;
		}
		
		return valorFinal;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(peca);
		sb.append(";");
		sb.append(quantidade);
		sb.append(";");
		sb.append(fabricante);
		sb.append(";");
		sb.append(pecaNova ? "Peça Nova" : "Peça Usada");
		
		return sb.toString();
	}
	
	public String getPeca() {
		return peca;
	}
	
	public void setPeca(String peca) {
		this.peca = peca;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public boolean isPecaNova() {
		return pecaNova;
	}
	
	public void setPecaNova(boolean pecaNova) {
		this.pecaNova = pecaNova;
	}
	
}
