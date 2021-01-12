/**
 * 
 */
package br.com.provider.dto.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author cbgomes
 *
 */
@Data
@AllArgsConstructor
public class EnderecoDTO {

	private String rua;
	
	private String cidade;

	private String estado;
}
