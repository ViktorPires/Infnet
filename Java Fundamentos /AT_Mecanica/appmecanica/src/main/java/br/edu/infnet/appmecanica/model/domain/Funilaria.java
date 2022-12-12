package br.edu.infnet.appmecanica.model.domain;

import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.FunilariaInvalidoException;

public class Funilaria extends Servico {

	private String material;
	private boolean martelinho;
	private boolean lanternagem;
	private boolean polimento;
	private boolean pintura;
	
	public Funilaria(String nome, float orcamento, int codigoRegistro, String material, boolean martelinho, boolean lanternagem, boolean polimento, boolean pintura) throws OrcamentoZeradoException, FunilariaInvalidoException {
		super(nome, orcamento, codigoRegistro);
		this.material = material;
		this.martelinho = martelinho;
		this.lanternagem = lanternagem;
		this.polimento = polimento;
		this.pintura = pintura;
		
		if(martelinho == false && lanternagem == false && polimento == false && pintura == false) {
			throw new FunilariaInvalidoException("É necessário definir ao menos um tipo de serviço de funilaria!");
		}
	}
	
	@Override
	public float calcularValorOrcamento() {
		
		float valorMartelinho = martelinho ? 400 : 0;
		float valorLanternagem = lanternagem ? 800 : 0;
		float valorPolimento = polimento ? 1200 : 0;
		float valorPintura = pintura ? 1000 : 0;
		
		return this.getOrcamento() + valorMartelinho + valorLanternagem + valorPolimento + valorPintura;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(material);
		sb.append(";");
		sb.append(martelinho ? "Martelinho = Sim" : "Martelinho = Não");
		sb.append(";");
		sb.append(lanternagem ? "Lanternagem = Sim" : "Lanternagem = Não");
		sb.append(";");
		sb.append(polimento ? "Polimento = Sim" : "Polimento = Não");
		sb.append(";");
		sb.append(pintura ? "Pintura = Sim" : "Pintura = Não");
		
		return sb.toString();
	}
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public boolean isMartelinho() {
		return martelinho;
	}
	
	public void setMartelinho(boolean martelinho) {
		this.martelinho = martelinho;
	}
	
	public boolean isLanternagem() {
		return lanternagem;
	}
	
	public void setLanternagem(boolean lanternagem) {
		this.lanternagem = lanternagem;
	}
	
	public boolean isPolimento() {
		return polimento;
	}
	
	public void setPolimento(boolean polimento) {
		this.polimento = polimento;
	}
	
	public boolean isPintura() {
		return pintura;
	}
	
	public void setPintura(boolean pintura) {
		this.pintura = pintura;
	}
	
}
