/**
 * 
 */
package br.com.provider.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.provider.model.pedido.Pedido;

/**
 * @author cbgomes
 *
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
