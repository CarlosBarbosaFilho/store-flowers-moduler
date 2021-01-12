/**
 * 
 */
package br.com.provider.repository.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.provider.model.produto.Produto;

/**
 * @author cbgomes
 *
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findByEstado(String estado);
	
	public List<Produto> findByIdIn(List<Long> ids);
	
}
