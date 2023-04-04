package br.edu.infnet.atapijavanuvem.controller;

import br.edu.infnet.atapijavanuvem.model.domain.DevedorPF;
import br.edu.infnet.atapijavanuvem.model.service.AmazonClientService;
import br.edu.infnet.atapijavanuvem.model.service.DevedorPFService;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/devedorpf/")
@Api(value = "Devedor Pessoa Física API", tags = {"Devedor PF"})
public class DevedorPFController {

	@Autowired 
	private DevedorPFService devedorPFService;

	@Autowired
	private AmazonClientService amazonClientService;

	@ApiOperation(value = "Retorna uma lista de devedores", tags = {"Devedor PF"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de devedores PF obtida com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 500, message = "Erro interno no servidor")
	})
	@GetMapping(value = "lista")
	public List<DevedorPF> obterLista(){
		return devedorPFService.obterLista();
	}

	@ApiOperation(value = "Retorna uma lista de devedores ativos", tags = {"Devedor PF"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de devedores PF ativos obtida com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 500, message = "Erro interno no servidor")
	})
	@GetMapping(value = "ativos")
	public List<DevedorPF> obterAtivos(){
		return devedorPFService.obterAtivos();
	}

	@ApiOperation(value = "Retorna um devedor ao informar o seu id", tags = {"Devedor PF"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Devedor PF obtido com sucesso"),
			@ApiResponse(code = 404, message = "Devedor PF não encontrado"),
			@ApiResponse(code = 500, message = "Erro interno no servidor")
	})
	@GetMapping(value = "{id}")
	public DevedorPF obterPorId(@PathVariable Integer id) {
		return devedorPFService.obterPorId(id);
	}
	
	@ApiOperation(value = "Cadastre um novo devedor pessoa física", tags = {"Devedor PF"})
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Devedor PF cadastrado com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 500, message = "Erro interno do servidor")
	})
	@PostMapping(value = "incluir")
	public void incluir(@RequestBody DevedorPF devedorPF) {
		devedorPFService.incluir(devedorPF);
	}

	@ApiOperation(value = "Atualiza os dados de um devedor existente", tags = {"Devedor PF"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Devedor PF atualizado com sucesso"),
			@ApiResponse(code = 404, message = "Devedor PF não encontrado")
	})
	@PutMapping(value = "{id}/editar")
	public ResponseEntity<String> editar(@PathVariable Integer id, @RequestBody DevedorPF devedorPFAtualizado) {
		DevedorPF devedorPF = devedorPFService.obterPorId(id);

		if (devedorPF.getId() != null && devedorPF.getId() != 0) {
			// atualiza os dados do devedorPF
			devedorPF.setNome(devedorPFAtualizado.getNome());
			devedorPF.setCpf(devedorPFAtualizado.getCpf());
			devedorPF.setCidade(devedorPFAtualizado.getCidade());
			devedorPF.setValor(devedorPFAtualizado.getValor());
			devedorPF.setAtivo(devedorPFAtualizado.getAtivo());
			devedorPFService.editar(devedorPF);

			return ResponseEntity.ok("Devedor pessoa física atualizado com sucesso.");
		}  else {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * Upload de arquivo
	 *
	 * Este endpoint realiza o upload de um arquivo para ser associado a um devedor pessoa física.
	 *
	 * @param id O id do devedor pessoa física que receberá o arquivo.
	 * @param file O arquivo a ser enviado.
	 *
	 * @throws ResponseStatusException se o devedor pessoa física não for encontrado ou se já existir um arquivo associado a ele.
	 */
	@ApiOperation(value = "Upload de arquivo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, tags = {"Devedor PF"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Arquivo enviado com sucesso"),
			@ApiResponse(code = 400, message = "Requisição inválida"),
			@ApiResponse(code = 404, message = "Devedor PF não encontrado"),
			@ApiResponse(code = 409, message = "Já existe um arquivo no devedor PF")
	})
	@PostMapping(value = "{id}/uploadArquivo")
	public void uploadArquivo(@PathVariable Integer id, @ApiParam(value = "Arquivo a ser enviado", required = true, type = "file") @RequestParam("file") MultipartFile file) throws IOException {
		DevedorPF devedorPF = devedorPFService.obterPorId(id);

		if(devedorPF.getId() == null || devedorPF.getId() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Devedor pessoa física não encontrado");
		}

		if(devedorPF.getArquivo() != null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um arquivo neste devedor");
		}

		byte[] bytes = file.getBytes();

		// Salvando a foto no S3 Bucket
		String fileName = id + "_" + file.getOriginalFilename();
		amazonClientService.save(bytes, fileName);

		// Obtendo a URL do arquivo salvo no S3 Bucket
		String url = amazonClientService.getFileUrl(fileName);

		// Atualizando o devedorPF com o nome do arquivo
		devedorPF.setArquivo(fileName);
		devedorPF.setArquivoUrl(url);
		devedorPFService.editar(devedorPF);
	}

	/**
	 * Realiza o download do arquivo associado a um devedor
	 *
	 * Este endpoint realiza o download do arquivo associado a um devedor pessoa física.
	 *
	 * @param id O id do devedor pessoa física que possui o arquivo.
	 *
	 * @return O arquivo baixado como um InputStreamResource.
	 *
	 * @throws ResponseStatusException se o devedor pessoa física não for encontrado ou se não houver um arquivo associado a ele.
	 */
	@ApiOperation(value = "Realiza o download do arquivo associado a um devedor", tags = {"Devedor PF"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Arquivo baixado com sucesso"),
			@ApiResponse(code = 404, message = "Devedor PF não encontrado ou Não há arquivo para download")
	})
	@GetMapping(value = "{id}/downloadArquivo")
	public ResponseEntity<InputStreamResource> downloadArquivo(@PathVariable Integer id) throws IOException {
		DevedorPF devedorPF = devedorPFService.obterPorId(id);

		if (devedorPF.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Devedor pessoa física não encontrado");
		}

		if (devedorPF.getArquivoUrl() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há arquivo para download");
		}

		// Obtém a URL do objeto no banco de dados
		String url = devedorPF.getArquivoUrl();

		// Extrai a chave do objeto da URL
		String[] parts = url.split("/");
		String objectKey = parts[parts.length - 1];

		// Faz o download do objeto do S3 Bucket
		S3Object s3object = amazonClientService.getObject(objectKey);
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		byte[] contents = IOUtils.toByteArray(inputStream);

		// Cria uma resposta HTTP com o arquivo como conteúdo
		InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(contents));
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + url + "\"");
		headers.add(HttpHeaders.CONTENT_TYPE, s3object.getObjectMetadata().getContentType());
		headers.add(HttpHeaders.CONTENT_LENGTH, Long.toString(s3object.getObjectMetadata().getContentLength()));
		return ResponseEntity.ok().headers(headers).body(resource);
	}

	@ApiOperation(value = "Deleta o arquivo associado a um devedor", tags = {"Devedor PF"})
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "O arquivo foi deletado com sucesso"),
			@ApiResponse(code = 404, message = "Devedor PF não encontrado ou não há arquivo para deletar")
	})
	@DeleteMapping(value = "{id}/deletarArquivo")
	public ResponseEntity<?> deletarArquivo(@PathVariable Integer id) {
		DevedorPF devedorPF = devedorPFService.obterPorId(id);

		if (devedorPF.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Devedor pessoa física não encontrado");
		}

		if (devedorPF.getArquivoUrl() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há arquivo para deletar");
		}

		// Obtém a chave do arquivo no banco de dados
		String url = devedorPF.getArquivoUrl();
		String[] parts = url.split("/");
		String objectKey = parts[parts.length - 1];

		// Deleta o arquivo do S3 Bucket
		amazonClientService.delete(objectKey);

		// Atualiza o devedorPF no banco de dados
		devedorPF.setArquivo(null);
		devedorPF.setArquivoUrl(null);
		devedorPFService.editar(devedorPF);

		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza o arquivo associado a um devedor", tags = {"Devedor PF"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Arquivo atualizado com sucesso"),
			@ApiResponse(code = 404, message = "Devedor PF não encontrado ou não há arquivo para atualizar")
	})
	@PutMapping(value = "{id}/atualizarArquivo")
	public ResponseEntity<?> atualizarArquivo(@PathVariable Integer id, @ApiParam(value = "Arquivo a ser enviado", required = true, type = "file") @RequestParam("file") MultipartFile file) throws IOException {
		DevedorPF devedorPF = devedorPFService.obterPorId(id);

		if (devedorPF.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Devedor não encontrado");
		}

		if (devedorPF.getArquivoUrl() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há arquivo para atualizar");
		}

		// Remove o arquivo anterior do S3 Bucket
		amazonClientService.delete(devedorPF.getArquivo());

		byte[] bytes = file.getBytes();

		// Salvando o arquivo no S3 Bucket
		String fileName = id + "_" + file.getOriginalFilename();
		amazonClientService.save(bytes, fileName);

		// Obtendo a URL do arquivo salvo no S3 Bucket
		String url = amazonClientService.getFileUrl(fileName);

		// Atualiza o registro correspondente no banco de dados
		devedorPF.setArquivo(fileName);
		devedorPF.setArquivoUrl(url);
		devedorPFService.editar(devedorPF);

		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Excluir um devedor com base no seu id", tags = {"Devedor PF"})
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Devedor PF excluído com sucesso"),
			@ApiResponse(code = 404, message = "Devedor PF não encontrado"),
			@ApiResponse(code = 500, message = "Erro interno no servidor")
	})
	@DeleteMapping(value = "{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		devedorPFService.excluir(id);
	}
}
