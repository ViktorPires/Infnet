package br.edu.infnet.appmecanica.model.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.appmecanica.model.exceptions.AtendimentoSemClienteException;
import br.edu.infnet.appmecanica.model.exceptions.AtendimentoSemServicoException;

@Entity
@Table(name = "TAtendimento")
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private LocalDate data;
	private String mecanicoResponsavel;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Servico> servicos;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	public Atendimento() {
		this.data = LocalDate.now();
	}

	
	public Atendimento(Cliente cliente, List<Servico> servicos, String descricao, String mecanicoResponsavel) throws AtendimentoSemClienteException, AtendimentoSemServicoException {
		this();
		
		if(cliente == null) {
			throw new AtendimentoSemClienteException("Não existe um cliente associado ao atendimento!");
		}
		
		if(servicos == null) {
			throw new AtendimentoSemServicoException("Não existe nenhum serviço associado ao atendimento!");
		}
		
		this.cliente = cliente;
		this.servicos = servicos;
		this.descricao = descricao;
		this.mecanicoResponsavel = mecanicoResponsavel;
		data = LocalDate.now();
	}
	
	public Atendimento(Cliente cliente, List<Servico> servicos) throws AtendimentoSemClienteException, AtendimentoSemServicoException {
		this();
		
		if(cliente == null) {
			throw new AtendimentoSemClienteException("Não existe um cliente associado ao atendimento!");
		}
		
		if(servicos == null) {
			throw new AtendimentoSemServicoException("Não existe nenhum serviço associado ao atendimento!");
		}
		
		this.cliente = cliente;
		this.servicos = servicos;
		data = LocalDate.now();
	}
	
	
	public void imprimir() {
		System.out.println("Atendimento: " + this);
		System.out.println("Cliente: " + cliente);
		System.out.println("Quantidade de Serviços: " + servicos.size());
		System.out.println("Serviços: ");
		float orcamentoFinal = 0;
		int i = 1;
		for(Servico s : servicos) {
			System.out.println("- " + s.getServico() + " -> Orçamento: R$" + s.getOrcamento());
			
			orcamentoFinal = orcamentoFinal + s.getOrcamento();
			
			if(i == servicos.size()) {
				System.out.println("Orçamento Total: R$" + orcamentoFinal);
			}
			i++;
		}
	}
	
	public String obterLinhaArq() {
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return this.getData().format(formatoData) + ";" + this.getDescricao() + ";" + this.getCliente() + ";" + this.getServicos().size() + "\r\n";
	}
	
	@Override
	public String toString() {
		
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return	String.format("%s;%s;%s", 
				descricao, 
				data.format(formatoData), 
				mecanicoResponsavel);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getMecanicoResponsavel() {
		return mecanicoResponsavel;
	}

	public void setMecanicoResponsavel(String mecanicoResponsavel) {
		this.mecanicoResponsavel = mecanicoResponsavel;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
