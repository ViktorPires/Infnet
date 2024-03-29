package br.edu.infnet.appmecanica.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.appmecanica.model.exceptions.ClienteInvalidoException;

@Entity
@Table(name = "TCliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String telefone;
	private String veiculo;
	private int anoVeiculo;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String email, String telefone, String veiculo, int anoVeiculo) throws ClienteInvalidoException {
		
		this();
		
		if(nome == null || nome == "") {
			throw new ClienteInvalidoException("O nome do cliente deve ser preenchido!");
		}
		
		if(email == null) {
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
		this.email = email;
		this.telefone = telefone;
		this.veiculo = veiculo;
		this.anoVeiculo = anoVeiculo;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(email);
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
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	
	public int getAnoVeiculo() {
		return anoVeiculo;
	}
	
	public void setAnoVeiculo(int anoVeiculo) {
		this.anoVeiculo = anoVeiculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
