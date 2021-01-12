/**
 * 
 */
package br.com.provider.controller.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.provider.form.fornecedor.FornecedorForm;
import br.com.provider.form.item.ItemForm;
import br.com.provider.service.pedido.PedidoService;
import lombok.RequiredArgsConstructor;

/**
 * @author cbgomes
 *
 */
@RestController
@RequestMapping("/api/v1/pedidos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PedidoController {

	private final PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<?> realizarPedido(@RequestBody List<ItemForm> itensForm){
		return ResponseEntity.ok(this.pedidoService.save(itensForm));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FornecedorForm> getByIdPedido(@PathVariable(name = "Long") Long id){
		return null;
	}
}
