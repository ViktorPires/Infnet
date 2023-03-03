package br.edu.infnet.appmecanica.model.domain;

import br.edu.infnet.appmecanica.model.exceptions.ClienteInvalidoException;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String endereco;
	private String telefone;
	private String veiculo;
	private int anoVeiculo;
	
	public Cliente(String nome, String endereco, String telefone, String veiculo, int anoVeiculo) throws ClienteInvalidoException {
		
		if(nome == null || nome == "") {
			throw new ClienteInvalidoException("O nome do cliente deve ser preenchido!");
		}
		
		if(endereco == null) {
			throw new ClienteInvalidoException("O endereço do cliente deve ser preenchido!");
		}
		
		if(telefone == null) {
			throw new ClienteInvalidoException("O telefone do cliente deve ser preenchido!");
		}
		
		if(veiculo == null) {
			throw new ClienteInvalidoException("O veículo do cliente deve ser preenchido!");
		}
		
		if(anoVeiculo == 0) {
			throw new ClienteInvalidoException("O ano do veículo não pode ser zero!");
		}
		
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
