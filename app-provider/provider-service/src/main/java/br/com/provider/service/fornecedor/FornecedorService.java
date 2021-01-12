/**
 * 
 */
package br.com.provider.service.fornecedor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.provider.dto.endereco.EnderecoDTO;
import br.com.provider.dto.fornecedor.FornecedorDTO;
import br.com.provider.model.fornecedor.Fornecedor;
import br.com.provider.repository.fornecedor.FornecedorRespository;
import lombok.RequiredArgsConstructor;

/**
 * @author cbgomes
 *
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FornecedorService {

	private final FornecedorRespository fornecedorRespository;
	
	@Transactional
	public Fornecedor save(FornecedorDTO dto) {
		return this.fornecedorRespository.save(dto.converteDto(dto));
	}
	
	@Transactional(readOnly = true)
	public Optional<Fornecedor> getById(Long idLong) {
		return this.fornecedorRespository.findById(idLong);
	}
	
	@Transactional(readOnly = true)
	public EnderecoDTO processaInfoFornecedor(String estado) {
		return this.fornecedorRespository.bucarEnderecoFornecedor(estado);
	}
}
