/**
 * 
 */
package br.com.flowers.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flowers.dto.compra.CompraDTO;
import br.com.flowers.service.RealizarCompraService;
import lombok.RequiredArgsConstructor;

/**
 * @author cbgomes
 *
 */
@RestController
@RequestMapping("/api/v1/comprar")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RealizarCompraController {
	
	private static final Logger LOGGER = Logger.getLogger(RealizarCompraController.class.getName());
	
	private final RealizarCompraService realizarCompraService;
	
	@PostMapping
	public void comprar(@RequestBody CompraDTO compraDto) {
		LOGGER.log(Level.INFO, "Processando o pedido na loja de flores, enviando no endereço" + compraDto.getEndereco());
		this.realizarCompraService.realizaCompra(compraDto);
	}
}
