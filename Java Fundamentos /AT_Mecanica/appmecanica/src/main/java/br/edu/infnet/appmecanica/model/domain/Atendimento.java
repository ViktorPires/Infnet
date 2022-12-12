package br.edu.infnet.appmecanica.model.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Atendimento {
	
	private String descricao;
	private LocalDate data;
	private String mecanicoResponsavel;
	private Cliente cliente;
	private List<Servico> servicos;
	
	public Atendimento() {
		data = LocalDate.now();
	}
	
	public void imprimir() {
		System.out.println("Atendimento: " + this);
		System.out.println("Cliente: " + cliente);
		System.out.println("Quantidade de Serviços: " + servicos.size());
		System.out.println("Serviços: ");
		for(Servico s : servicos) {
			System.out.println("- " + s.getNome() + " -> Orçamento: R$" + s.getOrcamento());
		}
	}
	
	@Override
	public String toString() {
		
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return	String.format("%s;%s;%s", 
				descricao, 
				data.format(formatoData), 
				mecanicoResponsavel);
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
	
}
