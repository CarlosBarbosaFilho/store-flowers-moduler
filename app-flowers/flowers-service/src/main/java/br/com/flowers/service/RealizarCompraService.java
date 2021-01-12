/**
 * 
 */
package br.com.flowers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.flowers.dto.compra.CompraDTO;
import br.com.flowers.dto.endereco.EnderecoDTO;
import lombok.RequiredArgsConstructor;

/**
 * @author cbgomes
 *
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RealizarCompraService {
	
	private final RestTemplate client;

	private final DiscoveryClient eurekaClient;
	
	public void realizaCompra(CompraDTO compraDto) {
		
		String path = compraDto.getEndereco().getEstado();
		ResponseEntity<EnderecoDTO> exchange = client.exchange("http://provider/info/"+path, HttpMethod.GET, null,EnderecoDTO.class);
		
		eurekaClient.getInstances("provider").stream()
			.forEach(provider -> {
				System.out.println("localhost:"+provider.getPort());
			});
		
		System.out.println(exchange.getBody().getCidade());
	}
	
}
