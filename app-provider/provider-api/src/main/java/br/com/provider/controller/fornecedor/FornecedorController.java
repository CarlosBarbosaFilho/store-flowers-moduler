/**
 * 
 */
package br.com.provider.controller.fornecedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.provider.dto.endereco.EnderecoDTO;
import br.com.provider.dto.fornecedor.FornecedorDTO;
import br.com.provider.form.fornecedor.FornecedorForm;
import br.com.provider.model.endereco.Endereco;
import br.com.provider.model.fornecedor.Fornecedor;
import br.com.provider.service.fornecedor.FornecedorService;
import lombok.RequiredArgsConstructor;

/**
 * @author cbgomes
 *
 */
@RestController
@RequestMapping("/info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FornecedorController {

	private final FornecedorService fornecedorService;
	
	@PostMapping
	public ResponseEntity<Fornecedor> save(@RequestBody FornecedorForm form){
		FornecedorDTO dto = new FornecedorForm().converteDto(form);
		return new ResponseEntity<Fornecedor>(this.fornecedorService.save(dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{estado}")
	public EnderecoDTO recuperaInfoFornecedor(@PathVariable(name = "estado") String estado) {
		return this.fornecedorService.processaInfoFornecedor(estado);
	}
	
	
}
