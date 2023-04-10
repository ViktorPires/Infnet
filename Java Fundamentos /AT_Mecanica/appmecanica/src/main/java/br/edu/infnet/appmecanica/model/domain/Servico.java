package br.edu.infnet.appmecanica.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import br.edu.infnet.appmecanica.model.exceptions.AcessorioEmFaltaException;
import br.edu.infnet.appmecanica.model.exceptions.OrcamentoZeradoException;
import br.edu.infnet.appmecanica.model.exceptions.QuantidadePecaInvalidoException;

@Entity
@Table(name = "TServico")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String servico;
	private float orcamento;
	private int codigoRegistro;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "servicos")
	private List<Atendimento> atendimentos;
	
	public Servico() {
		
	}
	
	public Servico(String servico, float orcamento) throws OrcamentoZeradoException {
		
		if(orcamento == 0) {
			throw new OrcamentoZeradoException("O orçamento não pode estar zerado!");
		}
		
		if(orcamento < 0) {
			throw new OrcamentoZeradoException("O orcamento não pode ser negativo!");
		}
		
		this.servico = servico;
		this.orcamento = orcamento;
	}
	

	public Servico(String servico, float orcamento, int codigoRegistro) throws OrcamentoZeradoException {
		
		if(orcamento == 0) {
			throw new OrcamentoZeradoException("O orçamento não pode estar zerado!");
		}
		
		if(orcamento < 0) {
			throw new OrcamentoZeradoException("O orcamento não pode ser negativo!");
		}
		
		this.servico = servico;
		this.orcamento = orcamento;
		this.codigoRegistro = codigoRegistro;
	}
	
	public abstract float calcularValorOrcamento() throws QuantidadePecaInvalidoException, AcessorioEmFaltaException;
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(servico);
		sb.append(";");
		sb.append(orcamento);
		sb.append(";");
		sb.append(codigoRegistro);
		
		return sb.toString();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServico() {
		return servico;
	}
	
	public void setServico(String servico) {
		this.servico = servico;
	}

	public float getOrcamento() {
		return orcamento;
	}
	
	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}

	public int getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(int codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}
}
