package br.edu.infnet.appmecanica.model.domain;

import br.edu.infnet.appmecanica.model.auxiliar.Constante;
import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.FunilariaInvalidoException;

public class Funilaria extends Servico {

	private String material;
	private boolean martelinho;
	private boolean lanternagem;
	private boolean polimento;
	private boolean pintura;
	
	public Funilaria(String servico, float orcamento, Integer codigoRegistro, String material, boolean martelinho, boolean lanternagem, boolean polimento, boolean pintura) throws OrcamentoZeradoException, FunilariaInvalidoException {
		super(servico, orcamento, codigoRegistro);
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
		
		float valorMartelinho = martelinho ? Constante.MARTELINHO_SIM : Constante.SERVICO_NAO;
		float valorLanternagem = lanternagem ? Constante.LANTERNAGEM_SIM : Constante.SERVICO_NAO;
		float valorPolimento = polimento ? Constante.POLIMENTO_SIM : Constante.SERVICO_NAO;
		float valorPintura = pintura ? Constante.PINTURA_SIM : Constante.SERVICO_NAO;
		
		return this.getOrcamento() + valorMartelinho + valorLanternagem + valorPolimento + valorPintura;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(material);
		sb.append(";");
		sb.append(martelinho ? Constante.MARTELINHO_SIM_STR : Constante.MARTELINHO_NAO_STR);
		sb.append(";");
		sb.append(lanternagem ? Constante.LANTERNAGEM_SIM_STR : Constante.LANTERNAGEM_NAO_STR);
		sb.append(";");
		sb.append(polimento ? Constante.POLIMENTO_SIM_STR : Constante.POLIMENTO_NAO_STR);
		sb.append(";");
		sb.append(pintura ? Constante.PINTURA_SIM_STR : Constante.PINTURA_NAO_STR);
		
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
	
	public String getMartelinho() {
	    return martelinho ? "Sim" : "Não";
	}
	
	public void setMartelinho(boolean martelinho) {
		this.martelinho = martelinho;
	}
	
	public boolean isLanternagem() {
		return lanternagem;
	}
	
	public String getLanternagem() {
	    return lanternagem ? "Sim" : "Não";
	}
	
	public void setLanternagem(boolean lanternagem) {
		this.lanternagem = lanternagem;
	}
	
	public boolean isPolimento() {
		return polimento;
	}
	
	public String getPolimento() {
	    return polimento ? "Sim" : "Não";
	}
	
	public void setPolimento(boolean polimento) {
		this.polimento = polimento;
	}
	
	public boolean isPintura() {
		return pintura;
	}
	
	public String getPintura() {
	    return pintura ? "Sim" : "Não";
	}
	
	public void setPintura(boolean pintura) {
		this.pintura = pintura;
	}
	
}
