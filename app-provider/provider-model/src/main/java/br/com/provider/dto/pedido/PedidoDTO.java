/**
 * 
 */
package br.com.provider.dto.pedido;

import java.math.BigDecimal;
import java.util.List;

import br.com.provider.model.endereco.Endereco;
import br.com.provider.model.fornecedor.Fornecedor;
import br.com.provider.model.item_pedido.ItemPedido;
import br.com.provider.model.pedido.Pedido;
import lombok.Data;

/**
 * @author cbgomes
 *
 */
@Data
public class PedidoDTO {

	private Long id;

	private Integer numero;

	private BigDecimal valorTotaPedido;

	private List<ItemPedido> itensPedido;
	
	public Pedido converteDto(PedidoDTO dto) {
		Pedido peiddo = new Pedido();
		peiddo.setId(dto.getId());
		
		return peiddo;
	}

}
