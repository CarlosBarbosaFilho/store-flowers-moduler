/**
 * 
 */
package br.com.provider.service.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.provider.dto.produto.ProdutoDTO;
import br.com.provider.model.produto.Produto;
import br.com.provider.repository.produto.ProdutoRepository;
import lombok.RequiredArgsConstructor;

/**
 * @author cbgomes
 *
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	
	@Transactional
	public Produto save(ProdutoDTO produtoDto) {
		Produto produto = new ProdutoDTO().converteDto(produtoDto); 
		return this.produtoRepository.saveAndFlush(produto);
	}
	
	@Transactional(readOnly = true)
	public List<Produto> produtosEstado(String estado){
		return  this.produtoRepository.findByEstado(estado);
	}
}
