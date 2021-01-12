/**
 * 
 */
package br.com.provider.form.fornecedor;

import java.util.Optional;

import br.com.provider.dto.fornecedor.FornecedorDTO;
import br.com.provider.model.endereco.Endereco;
import br.com.provider.model.fornecedor.Fornecedor;
import lombok.Data;

/**
 * @author cbgomes
 *
 */
@Data
public class FornecedorForm {

	private Long id;
	
	private String nome;
	
	private String email;
	
	private Endereco endereco;
	
	
	public FornecedorDTO converteDto(FornecedorForm form) {
		FornecedorDTO dto = new FornecedorDTO();
		dto.setId(form.getId());
		dto.setNome(form.getNome());
		dto.setEmail(form.getEmail());
		dto.setCidade(form.getEndereco().getCidade());
		dto.setRua(form.getEndereco().getRua());
		dto.setEstado(form.getEndereco().getEstado());
		
		return dto;
	}
}
