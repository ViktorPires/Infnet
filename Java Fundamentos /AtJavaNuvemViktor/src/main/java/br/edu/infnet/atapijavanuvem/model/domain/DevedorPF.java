package br.edu.infnet.atapijavanuvem.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TDevedorPF")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Classe que representa um devedor pessoa física")
public class DevedorPF {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private Integer id;
	@ApiModelProperty(value = "Nome completo do devedor", example = "Joãozinho da Silva")
	private String nome;
	@ApiModelProperty(value = "CPF do devedor", example = "012.345.678-99")
	private String cpf;
	@ApiModelProperty(value = "Cidade de residência do devedor", example = "São Paulo")
	private String cidade;
	@ApiModelProperty(value = "Valor da dívida do devedor", example = "2000")
	private float valor;
	@ApiModelProperty(value = "Indica se o devedor está com a dívida em aberto", example = "true")
	private Boolean ativo;
	@Lob
	@Column(name = "arquivo")
	@ApiModelProperty(hidden = true)
	private String arquivo;
	@Column(name = "arquivo_url")
	@ApiModelProperty(hidden = true)
	private String arquivoUrl;


	@Override
	public String toString() {
		return String.format("%s - %s - %.2f",
				this.getNome(),
				this.getCpf(),
				this.getValor()
				);
	}

	public DevedorPF(Integer id){
		this.setId(id);
	}
}
