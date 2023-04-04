package br.edu.infnet.atapijavanuvem.model.service;

import br.edu.infnet.atapijavanuvem.model.domain.DevedorPF;
import br.edu.infnet.atapijavanuvem.model.repository.IDevedorPFRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DevedorPFService {

	@Autowired
	private IDevedorPFRepository devedorPFRepository;

	@ApiOperation(value = "Retorna uma lista de todos os devedores", response = DevedorPF.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de devedores recuperada com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno no servidor ao tentar recuperar a lista de devedores")
	})
	public List<DevedorPF> obterLista(){
		return devedorPFRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	@ApiOperation(value = "Retorna um devedor pelo seu ID", response = DevedorPF.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "DevedorPF recuperado com sucesso"),
			@ApiResponse(code = 404, message = "DevedorPF não encontrado"),
			@ApiResponse(code = 500, message = "Erro interno no servidor ao tentar recuperar o devedor")
	})
	public DevedorPF obterPorId(@ApiParam(value = "ID do devedor") Integer id) {
		return devedorPFRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Devedor não encontrado"));
	}

	@ApiOperation(value = "Retorna uma lista de todos os devedores com débitos ativos", response = DevedorPF.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de devedores ativos recuperada com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno no servidor ao tentar recuperar a lista de devedores ativos")
	})
	public List<DevedorPF> obterAtivos(){
		return devedorPFRepository.obterAtivos();
	}

	@ApiOperation(value = "Inclui um novo devedor pessoa física")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Devedor pessoa física incluído com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno no servidor ao tentar incluir o devedor")
	})
	public void incluir(@ApiParam(value = "Dados do novo devedor pessoa jurídica (Nome, CPF, Cidade, Valor do Débito e se está Ativo)") DevedorPF devedorPF) {
		devedorPFRepository.save(devedorPF);
	}

	@ApiOperation(value = "Atualiza os dados de um devedor pessoa física existente")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Dados do devedor pessoa física atualizados com sucesso"),
			@ApiResponse(code = 404, message = "Devedor pessoa física não encontrado"),
			@ApiResponse(code = 500, message = "Erro interno no servidor ao tentar atualizar os dados do devedor")
	})
	public void editar(@ApiParam(value = "Dados atualizados do devedor pessoa física (Nome, CPF, Cidade, Valor do Débito e se está Ativo)") DevedorPF devedorPF) {
		devedorPFRepository.save(devedorPF);
	}

	@ApiOperation(value = "Exclui um devedor pelo seu ID")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Devedor pessoa física excluído com sucesso"),
			@ApiResponse(code = 404, message = "Devedor pessoa física não encontrado"),
			@ApiResponse(code = 500, message = "Erro interno no servidor ao tentar excluir o devedor")
	})
	public void excluir(@ApiParam(value = "ID do devedor") Integer id) {
		devedorPFRepository.deleteById(id);
	}
}
