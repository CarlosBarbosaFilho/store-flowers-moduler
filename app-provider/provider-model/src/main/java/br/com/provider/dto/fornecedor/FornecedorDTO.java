/**
 * 
 */
package br.com.provider.dto.fornecedor;

import br.com.provider.model.endereco.Endereco;
import br.com.provider.model.fornecedor.Fornecedor;
import lombok.Data;

/**
 * @author cbgomes
 *
 */
@Data
public class FornecedorDTO {

	private Long id;

	private String nome;

	private String email;

	private String rua;
	
	private String cidade;
	
	private String estado;
	
	public Fornecedor converteDto(FornecedorDTO dto) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(dto.getId());
		fornecedor.setNome(dto.getNome());
		fornecedor.setEmail(dto.getEmail());
		Endereco endereco = new Endereco();
		endereco.setCidade(dto.getCidade());
		endereco.setRua(dto.getRua());
		endereco.setEstado(dto.getEstado());
		fornecedor.setEndereco(endereco);
		
		return fornecedor;
	}

}
