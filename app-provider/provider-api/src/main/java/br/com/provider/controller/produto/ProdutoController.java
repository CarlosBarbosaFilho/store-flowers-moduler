/**
 * 
 */
package br.com.provider.controller.produto;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.provider.dto.produto.ProdutoDTO;
import br.com.provider.form.fornecedor.FornecedorForm;
import br.com.provider.form.produto.ProdutoForm;
import br.com.provider.model.produto.Produto;
import br.com.provider.service.produto.ProdutoService;
import lombok.RequiredArgsConstructor;

/**
 * @author cbgomes
 *
 */
@RestController
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoController {

	private final ProdutoService produtoService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody ProdutoForm form, UriComponentsBuilder uriBuilder) {
		try {
			Produto produto = this.produtoService.save(new ProdutoForm().converteDto(form));
			URI uri = uriBuilder.path("/api/v1/produtos/{id}").buildAndExpand(produto.getId()).toUri();
			return ResponseEntity.created(uri).body(new ProdutoDTO().converteProduto(produto));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/{estado}")
	public ResponseEntity<List<?>> produtosEstado(@PathVariable String estado){
		try {
			return ResponseEntity.ok(this.produtoService.produtosEstado(estado));			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
