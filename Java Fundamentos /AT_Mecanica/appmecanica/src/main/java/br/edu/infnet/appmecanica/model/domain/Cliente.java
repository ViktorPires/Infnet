package br.edu.infnet.appmecanica.model.domain;

public class Cliente {
	
	private String nome;
	private String endereco;
	private String telefone;
	private String veiculo;
	private int anoVeiculo;
	
	public Cliente(String nome, String endereco, String telefone, String veiculo, int anoVeiculo) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.veiculo = veiculo;
		this.anoVeiculo = anoVeiculo;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(endereco);
		sb.append(";");
		sb.append(telefone);
		sb.append(";");
		sb.append(veiculo);
		sb.append(";");
		sb.append(anoVeiculo);
		
		return sb.toString();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getVeiculo() {
		return veiculo;
	}
	
	public int getAnoVeiculo() {
		return anoVeiculo;
	}
	
}
