package br.edu.infnet.atapijavanuvem.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "TDevedorPJ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Classe que representa um devedor pessoa jurídica")
public class DevedorPJ {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private Integer id;
	@ApiModelProperty(value = "Razão social do devedor", example = "Empresa XPTO S/A")
	private String razaosocial;
	@ApiModelProperty(value = "CNPJ do devedor", example = "12.345.678/0001-90")
	private String cnpj;
	@ApiModelProperty(value = "Cidade do devedor", example = "Porto Alegre")
	private String cidade;
	@ApiModelProperty(value = "Valor da dívida do devedor", example = "15000.50")
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
				this.getRazaosocial(),
				this.getCnpj(),
				this.getValor()
				);
	}

	public DevedorPJ(Integer id){
		this.setId(id);
	}
}
