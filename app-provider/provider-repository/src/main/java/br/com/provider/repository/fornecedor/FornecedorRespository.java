/**
 * 
 */
package br.com.provider.repository.fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import br.com.provider.dto.endereco.EnderecoDTO;
import br.com.provider.model.fornecedor.Fornecedor;

/**
 * @author cbgomes
 *
 */
@Component
public interface FornecedorRespository extends JpaRepository<Fornecedor, Long> {

	@Query(value = "SELECT new br.com.provider.dto.endereco.EnderecoDTO(f.endereco.rua, f.endereco.cidade, f.endereco.estado) FROM Fornecedor f WHERE f.endereco.estado = :estado")
	public EnderecoDTO bucarEnderecoFornecedor(String estado);
}
