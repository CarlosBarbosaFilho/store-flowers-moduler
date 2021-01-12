/**
 * 
 */
package br.com.provider.form.pedido;

import java.math.BigDecimal;
import java.util.List;

import br.com.provider.dto.pedido.PedidoDTO;
import br.com.provider.model.item_pedido.ItemPedido;
import lombok.Data;

/**
 * @author cbgomes
 *
 */
@Data
public class PedidoForm {

	private Long id;

	private Integer numero;

	private BigDecimal valorTotaPedido;

	private List<ItemPedido> itensPedido;
	
	
	public PedidoDTO converteDto(PedidoForm form) {
		PedidoDTO dto = new PedidoDTO();
		dto.setId(form.getId());
		dto.setNumero(form.getNumero());
		dto.setValorTotaPedido(form.getValorTotaPedido());
		dto.setItensPedido(form.getItensPedido());
		return dto;
	}
}
