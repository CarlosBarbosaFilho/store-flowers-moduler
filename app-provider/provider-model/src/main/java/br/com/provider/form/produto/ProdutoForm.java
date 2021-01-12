/**
 * 
 */
package br.com.provider.form.produto;

import java.math.BigDecimal;

import br.com.provider.dto.fornecedor.FornecedorDTO;
import br.com.provider.dto.produto.ProdutoDTO;
import br.com.provider.form.fornecedor.FornecedorForm;
import lombok.Data;

/**
 * @author cbgomes
 *
 */
@Data
public class ProdutoForm {

	private Long id;

	private String descricao;

	private String estado;

	private String nome;

	private BigDecimal preco;

	public ProdutoDTO converteDto(ProdutoForm form) {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setId(form.getId());
		dto.setNome(form.getNome());
		dto.setDescricao(form.getDescricao());
		dto.setEstado(form.getEstado());
		dto.setPreco(form.getPreco());

		return dto;
	}

}
