package br.edu.infnet.appmecanica.model.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.infnet.appmecanica.model.exceptions.AtendimentoSemClienteException;
import br.edu.infnet.appmecanica.model.exceptions.AtendimentoSemServicoException;


public class Atendimento {
	
	private String descricao;
	private LocalDate data;
	private String mecanicoResponsavel;
	private Cliente cliente;
	private List<Servico> servicos;
	
	public Atendimento(Cliente cliente, List<Servico> servicos) throws AtendimentoSemClienteException, AtendimentoSemServicoException {
		
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
			System.out.println("- " + s.getNome() + " -> Orçamento: R$" + s.getOrcamento());
			
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
	
	public List<Servico> getServicos() {
		return servicos;
	}
}
