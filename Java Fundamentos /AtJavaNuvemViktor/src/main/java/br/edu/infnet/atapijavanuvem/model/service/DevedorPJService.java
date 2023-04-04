package br.edu.infnet.atapijavanuvem.model.service;

import java.util.List;

import br.edu.infnet.atapijavanuvem.model.domain.DevedorPJ;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapijavanuvem.model.repository.IDevedorPJRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DevedorPJService {

	@Autowired
	private IDevedorPJRepository devedorPJRepository;

	@ApiOperation(value = "Retorna uma lista de todos os devedores", response = DevedorPJ.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de devedores recuperada com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno no servidor ao tentar recuperar a lista de devedores")
	})
	public List<DevedorPJ> obterLista(){
		return devedorPJRepository.findAll(Sort.by(Sort.Direction.ASC, "razaosocial"));
	}

	@ApiOperation(value = "Retorna um devedor pelo seu ID", response = DevedorPJ.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "DevedorPJ recuperado com sucesso"),
			@ApiResponse(code = 404, message = "DevedorPJ não encontrado"),
			@ApiResponse(code = 500, message = "Erro interno no servidor ao tentar recuperar o devedor")
	})
	public DevedorPJ obterPorId(@ApiParam(value = "ID do devedor") Integer id) {
		return devedorPJRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Devedor não encontrado"));
	}

	@ApiOperation(value = "Retorna uma lista de todos os devedores com débitos ativos", response = DevedorPJ.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de devedores ativos recuperada com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno no servidor ao tentar recuperar a lista de devedores ativos")
	})
	public List<DevedorPJ> obterAtivos(){
		return devedorPJRepository.obterAtivos();
	}

	@ApiOperation(value = "Inclui um novo devedorPJ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "DevedorPJ incluído com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno no servidor ao tentar incluir o devedorPJ")
	})
	public void incluir(@ApiParam(value = "Dados do novo devedorPJ (Razão Social, CNPJ, Cidade, Valor do Débito e se está Ativo)") DevedorPJ devedorPJ) {
		devedorPJRepository.save(devedorPJ);
	}

	@ApiOperation(value = "Atualiza os dados de um devedorPJ existente")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Dados do devedorPJ atualizados com sucesso"),
			@ApiResponse(code = 404, message = "DevedorPJ não encontrado"),
			@ApiResponse(code = 500, message = "Erro interno no servidor ao tentar atualizar os dados do devedorPJ")
	})
	public void editar(@ApiParam(value = "Dados atualizados do devedorPJ (Razão Social, CNPJ, Cidade, Valor do Débito e se está Ativo)") DevedorPJ devedorPJ) {
		devedorPJRepository.save(devedorPJ);
	}

	@ApiOperation(value = "Exclui um devedor pelo seu ID")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "DevedorPJ excluído com sucesso"),
			@ApiResponse(code = 404, message = "DevedorPJ não encontrado"),
			@ApiResponse(code = 500, message = "Erro interno no servidor ao tentar excluir o devedor")
	})
	public void excluir(@ApiParam(value = "ID do devedor") Integer id) {
		devedorPJRepository.deleteById(id);
	}
}
