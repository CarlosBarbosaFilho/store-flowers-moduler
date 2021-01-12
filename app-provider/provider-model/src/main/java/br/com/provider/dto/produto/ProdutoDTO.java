/**
 * 
 */
package br.com.provider.dto.produto;

import java.math.BigDecimal;

import br.com.provider.dto.fornecedor.FornecedorDTO;
import br.com.provider.model.endereco.Endereco;
import br.com.provider.model.fornecedor.Fornecedor;
import br.com.provider.model.produto.Produto;
import lombok.Data;

/**
 * @author cbgomes
 *
 */
@Data
public class ProdutoDTO {
	
	private Long id;

	private String descricao;

	private String estado;

	private String nome;

	private BigDecimal preco;
	
	public Produto converteDto(ProdutoDTO dto) {
		Produto produto = new Produto();
		produto.setId(dto.getId());
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setEstado(dto.getEstado());
		produto.setPreco(dto.getPreco());
		return produto;
	}

	public ProdutoDTO converteProduto(Produto produto) {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setId(produto.getId());
		dto.setNome(produto.getNome());
		dto.setDescricao(produto.getDescricao());
		dto.setEstado(produto.getEstado());
		dto.setPreco(produto.getPreco());
		return dto;
	}
}
