/**
 * 
 */
package br.com.flowers.dto.endereco;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author cbgomes
 *
 */
@Getter
@Setter
public class EnderecoDTO implements Serializable {

	private Long id;
	
	private String rua;
	
	private String cidade;
	
	private String estado;
}
