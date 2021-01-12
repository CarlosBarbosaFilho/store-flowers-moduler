/**
 * 
 */
package br.com.provider.service.pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.provider.form.item.ItemForm;
import br.com.provider.model.item_pedido.ItemPedido;
import br.com.provider.model.pedido.Pedido;
import br.com.provider.model.produto.Produto;
import br.com.provider.repository.pedido.PedidoRepository;
import br.com.provider.repository.produto.ProdutoRepository;
import lombok.RequiredArgsConstructor;

/**
 * @author cbgomes
 *
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PedidoService {

	private final PedidoRepository pedidoRepository;

	private final ProdutoRepository produtoRepository;
	
	@Transactional
	public Pedido save(List<ItemForm> itensForm) {
		BigDecimal valorTotal = BigDecimal.ZERO;
		
		List<ItemPedido> itensPedido = retornaItensPedido(itensForm);
		Pedido pedido = new Pedido();
		pedido.setItensPedido(itensPedido);
		pedido.setNumero(itensForm.size());
		valorTotal = itensPedido.stream().map(item -> item.getValorItemPedido()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		
		pedido.setValorTotaPedido(valorTotal);
		
		return pedidoRepository.save(pedido);
	}

	private List<ItemPedido> retornaItensPedido(List<ItemForm> itensForm) {

		List<Long> idsProdutos = itensForm.stream().map(item -> item.getId()).collect(Collectors.toList());

		List<Produto> produtosPedido = this.produtoRepository.findByIdIn(idsProdutos);

		List<ItemPedido> itensPedido = itensForm.stream().map(item -> {

			Produto produto = produtosPedido.stream().filter(p -> p.getId() == item.getId()).findFirst().get();

			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setProduto(produto);
			itemPedido.setQuantidade(item.getQuantidade());
			itemPedido.setValorItemPedido(produto.getPreco().multiply(item.getQuantidade()));
			return itemPedido;
			
		}).collect(Collectors.toList());

		return itensPedido;
	}

}
