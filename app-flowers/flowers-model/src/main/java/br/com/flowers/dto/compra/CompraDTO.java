/**
 * 
 */
package br.com.flowers.dto.compra;

import java.util.List;

import br.com.flowers.model.compra.Compra;
import br.com.flowers.model.endereco.Endereco;
import br.com.flowers.model.item.Item;
import br.com.flowers.utils.Mapper;
import lombok.Getter;
import lombok.Setter;

/**
 * @author cbgomes
 *
 */
@Getter
@Setter
public class CompraDTO{

	private List<Item> itens;
	
	private Endereco endereco;
	
	private CompraDTO dtoConverter(Compra compra) {
		CompraDTO dto = Mapper.modelMapper().map(compra, CompraDTO.class);
		return dto;
	}
	
	private Compra dtoConverter(CompraDTO dto) {
		Compra compra = Mapper.modelMapper().map(dto, Compra.class);
		return compra;
	}
}
